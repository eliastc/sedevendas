package br.com.suporteti.sedevendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.suporteti.sedevendas.domain.Cliente;
import br.com.suporteti.sedevendas.repositories.ClienteRepository;
import br.com.suporteti.sedevendas.services.exceptions.ObjectNaoFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNaoFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}




