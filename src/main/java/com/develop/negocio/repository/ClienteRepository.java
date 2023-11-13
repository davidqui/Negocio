package com.develop.negocio.repository;

import com.develop.negocio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {

    // Buscar todos los Clientes
    List<Cliente> findAll();

    // Ejemplos de consultas personalizadas
    List<Cliente> findByPersonaId(Integer personaId);

    // Encontrar persona por ID
    @Query("select p from Cliente p where p.personaId = ?1")
    Optional<Cliente> findById(Integer id);

    // Guardar un nuevo Cliente
    Cliente save(Cliente cliente);

    // Actualizar una Cliente existente
    Cliente saveAndFlush(Cliente cliente);

    // Eliminar Cliente por ID
    void deleteById(Integer id);

    // Eliminar una Cliente
    void delete(Cliente cliente);
}
