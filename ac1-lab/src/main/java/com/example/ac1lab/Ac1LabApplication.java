package com.example.ac1lab;

import com.example.ac1lab.repository.PedidoRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ac1LabApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ac1LabApplication.class, args);
	}

	// Acrescentado devido um erro na hora de iniciar o Spring-Boot
	@Bean
	public PedidoRepository pedidoRepository(){
		return new PedidoRepository();
	}

}
