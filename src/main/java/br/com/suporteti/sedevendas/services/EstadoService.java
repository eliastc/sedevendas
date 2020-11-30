package br.com.suporteti.sedevendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.suporteti.sedevendas.domain.Estado;
import br.com.suporteti.sedevendas.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll() {
		return repo.findAllByOrderByNome();
	}
   
	@Transactional
	public Estado insert(Estado obj) {
		obj.setId(null);
		obj = repo.save(obj);
        //	enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}	
	
	
}
