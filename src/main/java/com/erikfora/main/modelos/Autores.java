package com.erikfora.main.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autores {
    @JsonIgnoreProperties(ignoreUnknown = true)

    @Column
    @Id
    private int id;

    @Column
    @JsonAlias("name")
    private String nombre;

    @Column
    @JsonAlias("birth_year")
    private int nacimiento;

    @Column
    @JsonAlias("death_year")
    private int muerte;
}
