package com.erikfora.main.servicios;

import com.erikfora.main.modelos.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface autorRepo extends JpaRepository<Autores, Long> {
}
