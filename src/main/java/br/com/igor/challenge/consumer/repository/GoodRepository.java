package br.com.igor.challenge.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.challenge.consumer.entity.Good;

public interface GoodRepository extends JpaRepository<Good, Integer> {

}
