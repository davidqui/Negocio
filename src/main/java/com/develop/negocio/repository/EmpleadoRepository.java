package com.develop.negocio.repository;

import com.develop.negocio.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    // Ejemplo de consultas personalizadas
    List<Empleado> findByNombre(String nombre);
    List<Empleado> findByApellido(String apellido);

    // Encontrar empleado por ID
    @Query("select e from Empleado e where e.id = ?1")
    Optional<Empleado> findById(Integer id);

    // Eliminar empleado por ID
    void deleteById(Integer id);

    // Contar la cantidad de empleados
    long count();
}