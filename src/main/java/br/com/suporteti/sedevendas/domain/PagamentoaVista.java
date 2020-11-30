

package br.com.suporteti.sedevendas.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.suporteti.sedevendas.domain.enums.EstadoPagamento;


@Entity
@JsonTypeName("pagamentoaVista")
public class PagamentoaVista  extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;
	
	public PagamentoaVista() {		
	}

	public PagamentoaVista(Integer id, EstadoPagamento estado, Pedido pedido, Date dataPagamento, Date instante ) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.instante = instante;
	}
	
	public Date getDataPagamento() {
		return dataPagamento;
	}
	
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}
	
	
}
