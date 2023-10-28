package com.develop.negocio.controller;

import com.develop.negocio.entity.Persona;
import com.develop.negocio.repository.PersonaRepository;
import com.develop.negocio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    private  PersonaRepository personaRepository;


    @Autowired
    private  PersonaService personaService;
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Integer id) {
        return personaService.getPersonaById(id)
                .map(persona -> ResponseEntity.ok().body(persona))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crear una persona nueva en la base de datos
     * @param persona
     * @return
     */
    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        Persona createdPersona = personaService.createPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPersona);
    }


    /**
     * Actualizar una persona existente en la base de datos
     * @param id
     * @param updatedPersona
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Integer id, @RequestBody Persona updatedPersona) {
        Persona persona = personaService.updatePersona(id, updatedPersona);
        if (persona != null) {
            return ResponseEntity.ok().body(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Eliminar una persona existente en la base de datos
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Integer id) {
        personaService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }


}
