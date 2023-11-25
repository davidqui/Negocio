package com.develop.negocio.repository;

import com.develop.negocio.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    // Buscar todas las personas
    List<Persona> findAll();

      // Encontrar persona por ID
    @Query("select p from Persona p where p.id = ?1")
    Optional<Persona> findById(Integer id);

   // Guardar una nueva persona
    Persona save(Persona persona);

    // Actualizar una persona existente
    Persona saveAndFlush(Persona persona);

    // Eliminar persona por ID
    void deleteById(Integer id);

    // Eliminar una persona
    void delete(Persona persona);


}
