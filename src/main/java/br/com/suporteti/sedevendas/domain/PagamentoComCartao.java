package br.com.suporteti.sedevendas.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.suporteti.sedevendas.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	
	private Integer numeroDeParcelas;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;
	
	public PagamentoComCartao() {		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas, Date dataVencimento) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
		this.dataVencimento = dataVencimento;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}
