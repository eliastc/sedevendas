package br.com.suporteti.sedevendas.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.suporteti.sedevendas.domain.Cidade;
import br.com.suporteti.sedevendas.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}

	@Transactional
	public Cidade insert(Cidade obj) {
		obj.setId(null);
		obj = repo.save(obj);
        //	enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
			
	public List<Cidade> findAll() {
		return repo.findAll();
	}
}
