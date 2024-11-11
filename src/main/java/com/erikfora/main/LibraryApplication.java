package com.erikfora.main;

import com.erikfora.main.controlador.Menu;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner   {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String ...args) throws JsonProcessingException {
		Menu menu = new Menu();
		menu.iniciar();
	}
}
