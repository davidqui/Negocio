package com.develop.negocio.service;

import com.develop.negocio.entity.Persona;
import com.develop.negocio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

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
    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    /**
     * Actualizar una persona existente en la base de datos
     * @param id
     * @param updatedPersona
     * @return
     */
    public Persona updatePersona(Integer id, Persona updatedPersona) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(updatedPersona.getNombre());
                    persona.setApellido(updatedPersona.getApellido());
                    persona.setFechaNacimiento(updatedPersona.getFechaNacimiento());
                    persona.setNit(updatedPersona.getNit());
                    persona.setEdad(updatedPersona.getEdad());
                    persona.setFechaContrato(updatedPersona.getFechaContrato());
                    persona.setCorreo(updatedPersona.getCorreo());
                    persona.setSalario(updatedPersona.getSalario());
                    return personaRepository.save(persona);
                })
                .orElse(null);
    }

    /**
     * Eliminar una persona existente en la base de datos
     * @param id
     */
    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }
}
