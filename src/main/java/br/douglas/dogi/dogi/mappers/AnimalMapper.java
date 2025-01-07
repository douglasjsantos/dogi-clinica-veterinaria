package br.douglas.dogi.dogi.mappers;

import br.douglas.dogi.dogi.dtos.AnimalDTO;
import br.douglas.dogi.dogi.dtos.ClienteDTO;
import br.douglas.dogi.dogi.models.Animal;
import br.douglas.dogi.dogi.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    AnimalDTO animalParaAnimalDTO(Animal animal);

    Animal clienteDTOParaCliente(AnimalDTO animalDTO);
}
