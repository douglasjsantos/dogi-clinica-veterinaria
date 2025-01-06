package br.douglas.dogi.dogi.services;

import br.douglas.dogi.dogi.models.Cliente;
import br.douglas.dogi.dogi.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }
}
