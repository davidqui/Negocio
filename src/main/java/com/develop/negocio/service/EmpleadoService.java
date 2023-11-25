package com.develop.negocio.service;

import com.develop.negocio.entity.Empleado;
import com.develop.negocio.entity.Persona;
import com.develop.negocio.repository.EmpleadoRepository;
import com.develop.negocio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getAllPersonas() {
        return empleadoRepository.findAll();
    }

    /**
     * Encontrar persona por ID
     * @param id
     * @return
     */
    public Optional<Empleado> getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id);
    }

    /**
     * Crear una persona nueva en la base de datos
     * @param empleado
     * @return
     */
    public Empleado createPersona(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    /**
     * Actualizar una persona existente en la base de datos
     * @param id
     * @param updatedEmpleado
     * @return
     */
    public Empleado updateEmpleado(Integer id, Empleado updatedEmpleado) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setCargo(updatedEmpleado.getCargo());
                    empleado.setCategoria(updatedEmpleado.getCategoria());
                    empleado.setFechaContrato(updatedEmpleado.getFechaContrato());
                    empleado.setSalario(updatedEmpleado.getSalario());
                    return empleadoRepository.save(empleado);
                })
                .orElse(null);
    }

    /**
     * Eliminar una persona existente en la base de datos
     * @param id
     */
    public void deletePersona(Integer id) {
        empleadoRepository.deleteById(id);
    }

    /**
     * Obtener una persona por su id y sus empleados
     * @param personaId
     * @return
     */
    public List<Empleado> getEmpleadosByPersonaId(Integer personaId) {
        return empleadoRepository.findByPersonaId(personaId);
    }
}
