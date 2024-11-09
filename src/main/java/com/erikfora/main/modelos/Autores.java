package com.erikfora.main.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autores {
    @JsonIgnoreProperties(ignoreUnknown = true)

    @Id
    private int id;

    @JsonAlias("name")
    private String nombre;

    @JsonAlias("birth_year")
    private int nacimiento;

    @JsonAlias("death_year")
    private int muerte;
}
