package com.develop.negocio.repository;
import com.develop.negocio.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    // Buscar todos los Clientes
    List<Empleado> findAll();

    // Ejemplos de consultas personalizadas
    List<Empleado> findByPersonaId(Integer personaId);


    // Encontrar persona por ID
    @Query("select e from Empleado e where e.personaId = ?1")
    Optional<Empleado> findById(Integer id);

    // Guardar un nuevo Cliente
    Empleado save(Empleado empleado);

    // Actualizar una Cliente existente
    Empleado saveAndFlush(Empleado empleado);

    // Eliminar Cliente por ID
    void deleteById(Integer id);

    // Eliminar una Cliente
    void delete(Empleado empleado);
}
