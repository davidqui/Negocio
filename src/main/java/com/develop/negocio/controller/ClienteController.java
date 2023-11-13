package com.develop.negocio.controller;

import com.develop.negocio.entity.Cliente;
import com.develop.negocio.repository.ClienteRepository;
import com.develop.negocio.repository.PersonaRepository;
import com.develop.negocio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private PersonaRepository personaRepository;
    private ClienteRepository clienteRepository;


    @Autowired
    private ClienteService clienteService;

    /**
     * Obtener todas las personas
     *  @return
     */
    @GetMapping
    @ResponseBody
    public List<Cliente> getAllClientes() {

        return clienteService.getAllClientes();
    }


    /**
     * Encontrar persona por ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = Optional.ofNullable(clienteService.getClienteById(id));

        return cliente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crear una persona nueva en la base de datos
     * @param cliente
     * @return
     */
    @PostMapping
    public ResponseEntity<Cliente> createPersona(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }

    /**
     * Actualizar una persona existente en la base de datos
     *
     * @param id
     * @param updatedCliente
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> updatePersona(@PathVariable Integer id, @RequestBody Cliente updatedCliente) {
        Optional<Cliente> cliente = clienteService.updateCliente(id, updatedCliente);
        if (cliente != null) {
            return ResponseEntity.ok().body(cliente);
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
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }


}
