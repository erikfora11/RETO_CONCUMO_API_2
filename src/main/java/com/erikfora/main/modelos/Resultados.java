package com.erikfora.main.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resultados {
    int ID;

    @JsonAlias("results")
    List <Libro> libros;

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Resultados{" +
                "libros=" + libros +
                '}';
    }
}
