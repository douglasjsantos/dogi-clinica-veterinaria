package br.douglas.dogi.dogi.controller;

import br.douglas.dogi.dogi.dtos.ClienteDTO;
import br.douglas.dogi.dogi.dtos.ClienteInsertDTO;
import br.douglas.dogi.dogi.models.Cliente;
import br.douglas.dogi.dogi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteInsertDTO clienteInsertDTO) {

        ClienteDTO clienteDTO = clienteService.salvar(clienteInsertDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(clienteDTO);
    }


    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodosClientes(){
        List<ClienteDTO> clientes = clienteService.listarTodosClientes();


        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id){

       return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorId(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){

        clienteService.deletarPorId(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @RequestBody ClienteInsertDTO clienteInsertDTO){

        ClienteDTO clienteAtualizado = clienteService.atualizar(id, clienteInsertDTO);

        return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);
    }
}
