package br.com.suporteti.sedevendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.suporteti.sedevendas.domain.Pedido;
import br.com.suporteti.sedevendas.repositories.PedidoRepository;
import br.com.suporteti.sedevendas.services.exceptions.ObjectNaoFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNaoFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}




