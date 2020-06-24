package br.com.suporteti.sedevendas.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.suporteti.sedevendas.services.DbService;
import br.com.suporteti.sedevendas.services.EmailService;
import br.com.suporteti.sedevendas.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DbService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiatetestdatabase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
