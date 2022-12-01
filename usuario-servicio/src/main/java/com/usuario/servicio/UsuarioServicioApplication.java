package com.usuario.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UsuarioServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioServicioApplication.class, args);
	}

}