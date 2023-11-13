package com.develop.negocio.service;

import com.develop.negocio.entity.Cliente;
import com.develop.negocio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    /**
     * Encontrar persona por ID
     * @param id
     * @return
     */
    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    /**
     * Crear una Cliente nuevo en la base de datos
     * @param cliente
     * @return
     */
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> updateCliente(Integer id, Cliente updatedCliente) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setCategoria(updatedCliente.getCategoria());
                    cliente.setDireccion(updatedCliente.getDireccion());
                    cliente.setPreferencias(updatedCliente.getPreferencias());
                    cliente.setPuntuacion(updatedCliente.getPuntuacion());
                    cliente.setTelefono(updatedCliente.getTelefono());
                    cliente.setFechaRegistro(updatedCliente.getFechaRegistro());
                    cliente.setNotas(updatedCliente.getNotas());
                    return clienteRepository.save(cliente);
                });


    }

    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

}
