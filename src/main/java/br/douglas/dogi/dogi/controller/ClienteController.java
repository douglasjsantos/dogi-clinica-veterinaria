package br.douglas.dogi.dogi.controller;

import br.douglas.dogi.dogi.models.Cliente;
import br.douglas.dogi.dogi.repositories.ClienteRepository;
import br.douglas.dogi.dogi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/clientes")
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
       return clienteService.saveCliente(cliente);
    }

    @GetMapping("/clientes")
    public List<Cliente> retornarCliente(@RequestBody Cliente cliente) {
        return clienteService.findAllClientes();
    }
}
