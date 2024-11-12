package com.erikfora.main.servicios;

import com.erikfora.main.modelos.Libro;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IlibroRepo extends JpaRepository<Libro, Long> {

}
