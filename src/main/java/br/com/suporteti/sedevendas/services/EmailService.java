package br.com.suporteti.sedevendas.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.suporteti.sedevendas.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
