package br.com.igor.challenge.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.challenge.consumer.entity.Debt;

public interface DebtRepository extends JpaRepository<Debt, Integer> {

}
