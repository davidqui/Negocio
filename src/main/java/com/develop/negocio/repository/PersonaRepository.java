package com.develop.negocio.repository;

import com.develop.negocio.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    // Ejemplos de consultas personalizadas
    List<Persona> findByNombre(String nombre);
    List<Persona> findByApellido(String apellido);

    // Encontrar persona por ID
    @Query("select p from Persona p where p.id = ?1")
    Optional<Persona> findById(Integer id);

    // Eliminar persona por ID
    void deleteById(Integer id);

    // Contar la cantidad de personas
    long count();
}