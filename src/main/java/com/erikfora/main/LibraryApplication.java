package com.erikfora.main;

import com.erikfora.main.controlador.Menu;
import com.erikfora.main.servicios.autorRepo;
import com.erikfora.main.servicios.libroRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner   {
    @Autowired
	private libroRepo repolibro;
	@Autowired
	private autorRepo repoAutor;

    public LibraryApplication(libroRepo repolibro,autorRepo repoAutor) {
        this.repolibro = repolibro;
    }

    public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String ...args) throws JsonProcessingException {

		Menu menu = new Menu(repolibro,repoAutor);
		menu.iniciar();
	}
}
