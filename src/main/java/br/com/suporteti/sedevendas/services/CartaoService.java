package br.com.suporteti.sedevendas.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.suporteti.sedevendas.domain.PagamentoComCartao;

@Service
public class CartaoService {

	public void pagarComCartao(PagamentoComCartao pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}
