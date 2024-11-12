package com.erikfora.main.servicios;

import com.erikfora.main.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface libroRepo extends JpaRepository<Libro, Integer> {

    @Query(value = "SELECT * FROM libros WHERE lenguaje ILIKE :idioma",nativeQuery = true)
    Optional<Libro> findByLenguaje(@Param("idioma") String lenguaje);
}
