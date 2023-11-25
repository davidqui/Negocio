package com.develop.negocio.controller;

import com.develop.negocio.entity.Empleado;
import com.develop.negocio.entity.Persona;
import com.develop.negocio.repository.PersonaRepository;
import com.develop.negocio.service.EmpleadoService;
import com.develop.negocio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    private PersonaRepository personaRepository;

    @Autowired
    private  PersonaService personaService;

    @Autowired
    private EmpleadoService empleadoService;


    /**
     * Obtener todas las personas
     *  @return
     */
    @GetMapping
    @ResponseBody
    @Transactional // Añade esta anotación
    public List<Persona> getAllPersonasWithEmpleados() {
        List<Persona> personas = personaService.getAllPersonas();

        // Para cada persona, obtenemos la información de los empleados
        for (Persona persona : personas) {
            Integer personaId = persona.getId();
            List<Empleado> empleados = empleadoService.getEmpleadosByPersonaId(personaId);
            persona.setEmpleados(empleados);
        }

        return personas;
    }

    /**
     * Encontrar persona por ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Integer id) {
        Persona persona = personaService.getPersonaWithEmpleado(id);
        if (persona != null) {
            return ResponseEntity.ok().body(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear una persona nueva en la base de datos
     * @param persona
     * @return
     */
    @PostMapping
    public ResponseEntity<Persona> createPersonaWithEmpleados(@RequestBody Persona persona) {
        Persona createdPersona = personaService.createPersonaWithEmpleados(persona);
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
        Persona persona = personaService.updatePersonaWithEmpleados(id, updatedPersona);
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
