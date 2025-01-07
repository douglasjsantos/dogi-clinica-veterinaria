package br.douglas.dogi.dogi.controller;

import br.douglas.dogi.dogi.dtos.AnimalDTO;
import br.douglas.dogi.dogi.dtos.ClienteDTO;
import br.douglas.dogi.dogi.dtos.ClienteInsertDTO;
import br.douglas.dogi.dogi.services.AnimalService;
import br.douglas.dogi.dogi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/animais")

public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> listarTodosAnimais(){
        List<AnimalDTO> animalDTOS = animalService.listarTodosAnimais();


        return ResponseEntity.status(HttpStatus.OK).body(animalDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> buscarPorId(@PathVariable Long id){

       return ResponseEntity.status(HttpStatus.OK).body(animalService.buscarPorId(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){

        animalService.deletarPorId(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTO> atualizar(@PathVariable Long id, @RequestBody AnimalDTO animalDTO){

        AnimalDTO animalAtualizado = animalService.atualizar(id, animalDTO);

        return ResponseEntity.status(HttpStatus.OK).body(animalDTO);
    }
}
