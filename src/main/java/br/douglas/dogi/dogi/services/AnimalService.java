package br.douglas.dogi.dogi.services;

import br.douglas.dogi.dogi.dtos.AnimalDTO;
import br.douglas.dogi.dogi.dtos.ClienteDTO;
import br.douglas.dogi.dogi.dtos.ClienteInsertDTO;
import br.douglas.dogi.dogi.mappers.AnimalMapper;
import br.douglas.dogi.dogi.mappers.ClienteMapper;
import br.douglas.dogi.dogi.models.Animal;
import br.douglas.dogi.dogi.models.Cliente;
import br.douglas.dogi.dogi.repositories.AnimalRepository;
import br.douglas.dogi.dogi.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalMapper animalMapper;


    @Transactional
    public List<AnimalDTO> listarTodosAnimais() {
        List<Animal> animais = animalRepository.findAll();

        return animais.stream()
                .map(animalMapper::animalParaAnimalDTO)
                .toList();

    }

    @Transactional
    public AnimalDTO buscarPorId(@PathVariable Long id) {


        Optional<Animal> animal = animalRepository.findById(id);

        if(animal.isPresent()) {
            return animalMapper.animalParaAnimalDTO(animal.get());
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarPorId(Long id) {
        if(animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public AnimalDTO atualizar(Long id, AnimalDTO animalDTO) {

        Animal animalExistente = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));



        animalExistente.setNome(animalDTO.getNome());
        animalExistente.setEspecie(animalDTO.getEspecie());
        animalExistente.setRaca(animalDTO.getRaca());
        animalExistente.setSexo(animalDTO.getSexo());
        animalExistente.setIdade(animalDTO.getIdade());
        animalExistente.setCor(animalDTO.getCor());
        animalExistente.setPelagem(animalDTO.getPelagem());
        Animal animalAtualizado = animalRepository.save(animalExistente);


        return animalMapper.animalParaAnimalDTO(animalRepository.save(animalAtualizado));
    }
}
