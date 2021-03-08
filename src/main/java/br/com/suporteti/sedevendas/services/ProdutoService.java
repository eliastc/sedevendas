package br.com.suporteti.sedevendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.suporteti.sedevendas.domain.Categoria;
import br.com.suporteti.sedevendas.domain.Produto;
import br.com.suporteti.sedevendas.dto.ProdutoDTO;
import br.com.suporteti.sedevendas.repositories.CategoriaRepository;
import br.com.suporteti.sedevendas.repositories.ProdutoRepository;
import br.com.suporteti.sedevendas.services.exceptions.ObjectNaoFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNaoFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}
	
	private void updateData(Produto newObj, Produto obj) {
		newObj.setNome(obj.getNome());
	}
	
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeIgnoreCaseContainingAndCategoriasIn(nome, categorias, pageRequest);
		
	}
	
	public  Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getNome(), objDto.getPreco());
	}

	public List<Produto> findAll() {
		return repo.findAll();
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir");
		}
	}
}




