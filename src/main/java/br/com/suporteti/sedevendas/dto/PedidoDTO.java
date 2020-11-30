package br.com.suporteti.sedevendas.dto;

import java.io.Serializable;
//import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.com.suporteti.sedevendas.domain.Cliente;
import br.com.suporteti.sedevendas.domain.ItemPedido;

//import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.suporteti.sedevendas.domain.Pedido;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	// esta me repetindo as informações no postman /pedidos e nao vieram os itens de produto tenho que corrigir
	//private Pagamento pagamento;
	private String nome;
	
	
	private Cliente cliente;
	
	private Set<ItemPedido> itens = new HashSet<>();

	public PedidoDTO() {
	}

	public PedidoDTO(Pedido obj) {
		id = obj.getId();	
	//	pagamento = obj.getPagamento();
	//	clienteDto = getClienteDto();
		itens = obj.getItens();
		setCliente(obj.getCliente());
		nome = obj.getCliente().getNome();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
