package br.douglas.dogi.dogi.repositories;

import br.douglas.dogi.dogi.models.Animal;
import br.douglas.dogi.dogi.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
