package br.com.igor.challenge.consumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/last-update")
public class LastUpdateController {
	
	@GetMapping()
	public ResponseEntity<Void> getLastUpdate() {
		return ResponseEntity.ok().build();
	}

}
