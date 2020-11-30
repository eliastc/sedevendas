package br.com.suporteti.sedevendas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.suporteti.sedevendas.domain.PagamentoComBoleto;
import br.com.suporteti.sedevendas.domain.PagamentoComCartao;
import br.com.suporteti.sedevendas.domain.PagamentoaVista;

@Configuration
public class JacksonConfig {
// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PagamentoComCartao.class);
				objectMapper.registerSubtypes(PagamentoComBoleto.class);				
				objectMapper.registerSubtypes(PagamentoaVista.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}