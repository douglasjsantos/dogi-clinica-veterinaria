package br.douglas.dogi.dogi.services;

import br.douglas.dogi.dogi.dtos.AnimalDTO;
import br.douglas.dogi.dogi.dtos.AnimalResumoDTO;
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

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;


    @Transactional
    public ClienteDTO salvar(ClienteInsertDTO clienteInsertDTO) {


        Cliente cliente = new Cliente();

        cliente.setNome(clienteInsertDTO.getNome());
        cliente.setSobrenome(clienteInsertDTO.getSobrenome());
        cliente.setEmail(clienteInsertDTO.getEmail());
        cliente.setTelefone(clienteInsertDTO.getTelefone());
        cliente.setCpf(clienteInsertDTO.getCpf());
        cliente.setSenha(clienteInsertDTO.getSenha());
        cliente.setDataCadastro(LocalDate.now());

        if (clienteInsertDTO.getAnimais() != null) {
            for (AnimalResumoDTO animalDTO : clienteInsertDTO.getAnimais()) {
                Animal animal = new Animal();
                animal.setNome(animalDTO.getNome());
                animal.setEspecie(animalDTO.getEspecie());
                animal.setRaca(animalDTO.getRaca());
                animal.setIdade(animalDTO.getIdade());
                animal.setSexo(animalDTO.getSexo());
                animal.setCor(animalDTO.getCor());
                animal.setPelagem(animalDTO.getPelagem());
                animal.setCliente(cliente);
                cliente.getAnimais().add(animal);
            }
        }

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteMapper.clienteParaClienteDTO(clienteSalvo);
    }

    @Transactional
    public List<ClienteDTO> listarTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(clienteMapper::clienteParaClienteDTO)
                .toList();

    }

    @Transactional
    public ClienteDTO buscarPorId(@PathVariable Long id) {


        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()) {
            return clienteMapper.clienteParaClienteDTO(cliente.get());
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarPorId(Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public ClienteDTO atualizar(Long id, ClienteInsertDTO clienteInsertDTO) {

        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteExistente.setNome(clienteInsertDTO.getNome());
        clienteExistente.setSobrenome(clienteInsertDTO.getNome());
        clienteExistente.setEmail(clienteInsertDTO.getEmail());
        clienteExistente.setTelefone(clienteInsertDTO.getTelefone());
        clienteExistente.setCpf(clienteInsertDTO.getCpf());
        clienteExistente.setSenha(clienteInsertDTO.getSenha());
        clienteExistente.setDataAtualizacao(LocalDate.now());
        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);


        return clienteMapper.clienteParaClienteDTO(clienteRepository.save(clienteAtualizado));
    }
}
