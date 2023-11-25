package com.develop.negocio.service;

import com.develop.negocio.entity.Empleado;
import com.develop.negocio.entity.Persona;
import com.develop.negocio.repository.EmpleadoRepository;
import com.develop.negocio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Transactional(readOnly = true)
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    /**
     * Encontrar persona por ID
     * @param id
     * @return
     */
    public Optional<Persona> getPersonaById(Integer id) {
        return personaRepository.findById(id);
    }

    /**
     * Crear una persona nueva en la base de datos
     * @param persona
     * @return
     */
    @Transactional
    public Persona createPersona(Persona persona) {

        return personaRepository.save(persona);
    }

    @Transactional
    public Persona createPersonaWithEmpleados(Persona persona) {
        // Guarda la persona
        Persona createdPersona = personaRepository.save(persona);

        // Asigna la nueva persona a los empleados si ya están asociados en la entidad Persona
        List<Empleado> empleados = persona.getEmpleados();
        if (empleados != null && !empleados.isEmpty()) {
            for (Empleado empleado : empleados) {
                empleado.setPersonaId(createdPersona.getId());
                // Guarda el empleado
                empleadoRepository.save(empleado);
            }
        }

        return createdPersona;
    }



    /**
     * Actualizar una persona existente en la base de datos
     * @param id
     * @param updatedPersona
     * @return
     */
    @Transactional
    public Persona updatePersonaWithEmpleados(Integer id, Persona updatedPersona) {
        Persona persona = personaRepository.findById(id).orElse(null);

        if (persona != null) {
            // Actualiza los campos de la persona
            persona.setNombre(updatedPersona.getNombre());
            persona.setApellido(updatedPersona.getApellido());
            persona.setFechaNacimiento(updatedPersona.getFechaNacimiento());
            persona.setNit(updatedPersona.getNit());
            persona.setEdad(updatedPersona.getEdad());
            persona.setCorreo(updatedPersona.getCorreo());

            // Actualiza los empleados asociados con la nueva información de la persona
            List<Empleado> empleadosToUpdate = updatedPersona.getEmpleados();

            if (empleadosToUpdate != null && !empleadosToUpdate.isEmpty()) {
                for (Empleado empleado : empleadosToUpdate) {
                    // Verifica si el empleado existe en la base de datos
                    Optional<Empleado> existingEmpleado = empleadoRepository.findById(empleado.getEmpleadoId());

                    if (existingEmpleado.isPresent()) {
                        // Actualiza los campos específicos de Empleado con la información de updatedPersona
                        existingEmpleado.get().setSalario(empleado.getSalario());
                        existingEmpleado.get().setCategoria(empleado.getCategoria());
                        existingEmpleado.get().setCargo(empleado.getCargo());
                        existingEmpleado.get().setFechaContrato(empleado.getFechaContrato());

                        // Guarda los cambios en el Empleado
                        empleadoRepository.save(existingEmpleado.get());
                    }
                }
            }

            // Guarda los cambios en la persona
            return personaRepository.save(persona);
        }

        return null;
    }



    /**
     *  Obtener una persona por su id y sus empleados
     * @param id
     * @return
     */
    public Empleado getEmpleadoWithPersona(Integer empleadoId) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElse(null);
        if (empleado != null) {
            Persona persona = personaRepository.findById(empleado.getPersonaId()).orElse(null);
            empleado.setPersona(persona);
        }
        return empleado;
    }


    /**
     * Obtener una persona por su id y sus empleados
     * @param personaId id de la persona
     * @return
     */
    public Persona getPersonaWithEmpleado(Integer personaId) {
        Persona persona = personaRepository.findById(personaId).orElse(null);
        if (persona != null) {
            List<Empleado> empleados = empleadoRepository.findByPersonaId(personaId);
            persona.setEmpleados(empleados);
        }
        return persona;
    }

    /**
     * Obtener una persona por su id y sus empleados
     * @param personaId
     * @return
     */
    public List<Empleado> getEmpleadosByPersonaId(Integer personaId) {
        return empleadoRepository.findByPersonaId(personaId);
    }


    /**
     * Eliminar una persona existente en la base de datos
     * @param id
     */
    @Transactional
    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }
}
