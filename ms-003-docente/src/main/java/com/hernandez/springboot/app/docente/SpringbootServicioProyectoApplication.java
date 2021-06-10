package com.hernandez.springboot.app.docente;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.hernandez.springboot.app.commons"})
public class SpringbootServicioProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioProyectoApplication.class, args);
	}

}
