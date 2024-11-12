package com.erikfora.main.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "autores")

public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(columnDefinition = "serial")
    @JsonAlias("name")
    private String nombre;


    @JsonAlias("birth_year")
    private int nacimiento;


    @JsonAlias("death_year")
    private int muerte;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getMuerte() {
        return muerte;
    }

    public void setMuerte(int muerte) {
        this.muerte = muerte;
    }

    @Override
    public String toString() {
        return "Autores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", muerte=" + muerte +
                '}';
    }
}
