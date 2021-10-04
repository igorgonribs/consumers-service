package br.com.igor.challenge.consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.igor.challenge.consumer.entity.LastUpdate;

public interface LastUpdateRepository extends MongoRepository<LastUpdate, String>{

}
