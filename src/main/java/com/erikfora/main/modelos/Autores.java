package com.erikfora.main.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "autores")
public class Autores {
    @JsonIgnoreProperties(ignoreUnknown = true)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonAlias("name")
    private String nombre;


    @JsonAlias("birth_year")
    private int nacimiento;


    @JsonAlias("death_year")
    private int muerte;
}
