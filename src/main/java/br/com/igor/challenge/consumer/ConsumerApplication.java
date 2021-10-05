package br.com.igor.challenge.consumer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.igor.challenge.consumer.entity.ClientDebts;
import br.com.igor.challenge.consumer.entity.ClientGoods;
import br.com.igor.challenge.consumer.entity.CreditCardTransaction;
import br.com.igor.challenge.consumer.entity.Debt;
import br.com.igor.challenge.consumer.entity.FinancialMovement;
import br.com.igor.challenge.consumer.entity.Good;
import br.com.igor.challenge.consumer.entity.LastUpdate;
import br.com.igor.challenge.consumer.enums.TransactionType;
import br.com.igor.challenge.consumer.repository.ClientDebtsRepository;
import br.com.igor.challenge.consumer.repository.ClientGoodsRepository;
import br.com.igor.challenge.consumer.repository.DebtRepository;
import br.com.igor.challenge.consumer.repository.GoodRepository;
import br.com.igor.challenge.consumer.repository.LastUpdateRepository;

@SpringBootApplication
public class ConsumerApplication implements CommandLineRunner {

	@Autowired
	private LastUpdateRepository repositoryLastUpdate;

	@Autowired
	private ClientGoodsRepository clientGoodsRepository;

	@Autowired
	private ClientDebtsRepository clientDebtsRepository;

	@Autowired
	private GoodRepository goodRepository;

	@Autowired
	private DebtRepository debtRepository;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//loadLastUpdates();
		loadClientDebts();
		loadClientGoods();
	}

	private void loadClientGoods() {
		ClientGoods clientGoods1 = new ClientGoods();
		clientGoods1.setAddress("Rua Péricles Vieira da Mota");
		clientGoods1.setAge(25);
		clientGoods1.setCpf("11094463655");
		clientGoods1.setIncome(5400.0);
		clientGoodsRepository.save(clientGoods1);

		List<Good> goodsList = new ArrayList<Good>();
		Good good1ClientGoods1 = new Good();
		good1ClientGoods1.setDescription("Casa");
		good1ClientGoods1.setValue(100000.0);
		good1ClientGoods1.setClientGoods(clientGoods1);
		
		Good good2ClientGoods1 = new Good();
		good2ClientGoods1.setDescription("Carro");
		good2ClientGoods1.setValue(2000.0);
		good2ClientGoods1.setClientGoods(clientGoods1);

		goodRepository.saveAll(Arrays.asList(good1ClientGoods1, good2ClientGoods1));

		goodsList.addAll(Arrays.asList(good1ClientGoods1, good2ClientGoods1));
		clientGoods1.setGoods(goodsList);
		clientGoodsRepository.save(clientGoods1);
	}

	private void loadClientDebts() {
		ClientDebts clientDebts1 = new ClientDebts();
		clientDebts1.setAddress("Rua Péricles Vieira da Mota");
		clientDebts1.setName("Igor Gonçalves Ribeiro Silva");
		clientDebts1.setCpf("11094463655");
		clientDebtsRepository.save(clientDebts1);

		List<Debt> debtsList = new ArrayList<Debt>();
		Debt debt1ClientDebts1 = new Debt();
		debt1ClientDebts1.setDescription("Geladeira");
		debt1ClientDebts1.setValue(2000.0);
		debt1ClientDebts1.setClientDebts(clientDebts1);
		
		Debt debt2ClientDebts1 = new Debt();
		debt2ClientDebts1.setDescription("Empréstimo");
		debt2ClientDebts1.setValue(8000.0);
		debt2ClientDebts1.setClientDebts(clientDebts1);

		debtRepository.saveAll(Arrays.asList(debt1ClientDebts1, debt2ClientDebts1));

		debtsList.addAll(Arrays.asList(debt1ClientDebts1, debt2ClientDebts1));
		clientDebts1.setDebts(debtsList);
		clientDebtsRepository.save(clientDebts1);

	}

	private void loadLastUpdates() {
		LastUpdate load = LastUpdate.builder().cpf("11094463655").lastQuery(LocalDateTime.now())
				.lastCreditCardTransaction(
						CreditCardTransaction.builder().timestamp(LocalDateTime.now()).value(100.0).build())
				.lastTransaction(FinancialMovement.builder().timestamp(LocalDateTime.now())
						.type(TransactionType.DEPOSIT).value(150.0).build())
				.build();
		repositoryLastUpdate.insert(load);
	}

}
