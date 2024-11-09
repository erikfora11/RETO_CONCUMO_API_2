package com.erikfora.main;

import com.erikfora.main.controlador.controlador;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner   {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String ...args) throws JsonProcessingException {
		controlador control = new controlador();
		control.buscar_libro();
	}
}
