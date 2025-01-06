package br.douglas.dogi.dogi.mappers;

import br.douglas.dogi.dogi.dtos.ClienteDTO;
import br.douglas.dogi.dogi.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteParaClienteDTO(Cliente cliente);

    Cliente clienteDTOParaCliente(ClienteDTO clienteDTO);
}
