package br.com.igor.challenge.consumer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.challenge.consumer.entity.ClientDebts;

public interface ClientDebtsRepository extends JpaRepository<ClientDebts, Integer> {

	Optional<ClientDebts> findByCpf(String cpf);
}
