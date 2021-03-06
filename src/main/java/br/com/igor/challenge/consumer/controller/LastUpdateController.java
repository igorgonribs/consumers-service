package br.com.igor.challenge.consumer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.challenge.consumer.entity.LastUpdate;
import br.com.igor.challenge.consumer.repository.LastUpdateRepository;

@RestController
@RequestMapping(path = "/no-security/api/last-update")
@EnableCaching
public class LastUpdateController {
	
	@Autowired
	private LastUpdateRepository repository;
	
	@GetMapping("/{cpf}")
	@Cacheable("last-update")
	public ResponseEntity<LastUpdate> getLastUpdate(@PathVariable("cpf") String cpf) {
		Optional<LastUpdate> lastUpdate = repository.findById(cpf);
		
		if(lastUpdate.isPresent())
			return ResponseEntity.ok(lastUpdate.get());
		
		return ResponseEntity.notFound().build();
	}

}
