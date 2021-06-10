package com.hernandez.springboot.app.usuarios;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean("ClienteRest")
	@LoadBalanced
	public RestTemplate registrarRestmplate() {
		return new RestTemplate();
	}
}
