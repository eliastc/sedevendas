package br.com.suporteti.sedevendas.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.suporteti.sedevendas.domain.PagamentoaVista;

@Service
public class vistaService {

	public static void pagaraVista(PagamentoaVista pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataPagamento(cal.getTime());
	}
}
