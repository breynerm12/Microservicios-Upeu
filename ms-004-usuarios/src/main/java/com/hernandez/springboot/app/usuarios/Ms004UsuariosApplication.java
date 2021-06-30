package com.hernandez.springboot.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.hernandez.springboot.app.commons.models.entity"})
@SpringBootApplication
public class Ms004UsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms004UsuariosApplication.class, args);
	}

}
