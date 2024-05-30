package com.example.ClienteService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación que marca esta clase como la aplicación principal de Spring
@SpringBootApplication
public class ClienteServiceApplication {
	public static void main(String[] args) {
		// Método principal que lanza la aplicación Spring
		SpringApplication.run(ClienteServiceApplication.class, args);
	}
}
