package br.douglas.dogi.dogi.repositories;

import br.douglas.dogi.dogi.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
