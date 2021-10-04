package br.com.igor.challenge.consumer;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.igor.challenge.consumer.entity.CreditCardTransaction;
import br.com.igor.challenge.consumer.entity.FinancialMovement;
import br.com.igor.challenge.consumer.entity.LastUpdate;
import br.com.igor.challenge.consumer.enums.TransactionType;
import br.com.igor.challenge.consumer.repository.LastUpdateRepository;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	/*
	 * @Bean CommandLineRunner runner(LastUpdateRepository repository) { return args
	 * -> { LastUpdate load =
	 * LastUpdate.builder().cpf("11094463655").lastQuery(LocalDateTime.now())
	 * .lastCreditCardTransaction(CreditCardTransaction.builder()
	 * .timestamp(LocalDateTime.now()).value(100.0).build())
	 * .lastTransaction(FinancialMovement.builder().timestamp(LocalDateTime.now())
	 * .type(TransactionType.DEPOSIT).value(150.0).build()) .build();
	 * repository.insert(load); }; }
	 */
}
