package br.com.igor.challenge.consumer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.challenge.consumer.entity.ClientGoods;

public interface ClientGoodsRepository extends JpaRepository<ClientGoods, Integer> {

	Optional<ClientGoods> findByCpf(String cpf);
}
