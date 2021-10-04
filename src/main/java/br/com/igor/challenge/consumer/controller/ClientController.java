package br.com.igor.challenge.consumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/client")
public class ClientController {
	@GetMapping("/debts")
	public ResponseEntity<Void> getClient() {
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/goods")
	public ResponseEntity<Void> getGoods() {
		return ResponseEntity.ok().build();
	}
}
