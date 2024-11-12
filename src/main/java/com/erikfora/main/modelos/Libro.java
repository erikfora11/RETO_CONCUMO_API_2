package com.erikfora.main.modelos;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "libros")
public class Libro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "serial")
    @JsonAlias("title")
    private String titulo;


    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL,fetch =FetchType.EAGER )
    @JsonAlias("authors")
    List<Autores> autores;


    @JsonAlias("download_count")
    private int descargas;

    @JsonAlias("languages")
    @Column(name = "lenguaje")
    private  List<String> lenguaje;

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", descargas=" + descargas +
                ", lenguaje='" + lenguaje + '\'' +
                '}';
    }

    public List<String> getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(List<String> lenguaje) {
        this.lenguaje = lenguaje;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        this.autores = autores;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }


}
