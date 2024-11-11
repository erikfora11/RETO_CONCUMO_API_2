package com.erikfora.main.modelos;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Libro {

    @Column
    @Id
    private int id;

    @Column
    @JsonAlias("title")
    private String titulo;

    @Column
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
    @JsonAlias("authors")
    List<Autores> autores;

    @Column
    @JsonAlias("download_count")
    private int descargas;

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

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", descargas=" + descargas +
                '}';
    }
}
