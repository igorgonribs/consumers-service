package br.com.igor.challenge.consumer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.challenge.consumer.entity.ClientDebts;
import br.com.igor.challenge.consumer.entity.ClientGoods;
import br.com.igor.challenge.consumer.entity.Good;
import br.com.igor.challenge.consumer.repository.ClientDebtsRepository;
import br.com.igor.challenge.consumer.repository.ClientGoodsRepository;

@RestController
@RequestMapping(path = "/api/client")
public class ClientController {

	@Autowired
	public ClientDebtsRepository debtsRepository;

	@Autowired
	public ClientGoodsRepository goodsRepository;

	@GetMapping("/debts/{cpf}")
	public ResponseEntity<?> getClient(@PathVariable("cpf") String cpf) {
		Optional<ClientDebts> clientDebts = debtsRepository.findByCpf(cpf);
		return resolveResponse(clientDebts);
	}

	@GetMapping("/goods/{cpf}")
	public ResponseEntity<?> getGoods(@PathVariable("cpf") String cpf) {
		Optional<ClientGoods> clientGoods = goodsRepository.findByCpf(cpf);
		return resolveResponse(clientGoods);
	}
	
	@GetMapping("/goods/machine-learning/{cpf}")
	public ResponseEntity<?> getGoodsForMachineLearning(@PathVariable("cpf") String cpf) {
		Optional<ClientGoods> clientGoods = goodsRepository.findByCpf(cpf);
		
		formatToMachineLearning(clientGoods);
		return resolveResponse(clientGoods);
	}

	private void formatToMachineLearning(Optional<ClientGoods> clientGoods) {
		if(clientGoods.isPresent()) {
			clientGoods.get().setPatrimony(calculatePatrimony(clientGoods.get().getGoods()));
			clientGoods.get().setGoods(null);
		}
	}

	private double calculatePatrimony(List<Good> goods) {
		return goods.stream().mapToDouble(good->good.getValue()).reduce(0.0, Double::sum);
	}

	private ResponseEntity<?> resolveResponse(Optional<?> item) {
		if (item.isPresent())
			return ResponseEntity.ok(item.get());

		return ResponseEntity.notFound().build();
	}
}
