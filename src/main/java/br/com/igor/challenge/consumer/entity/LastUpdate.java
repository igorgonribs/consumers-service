package br.com.igor.challenge.consumer.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document
@Builder
public class LastUpdate {

	@Id
	public String cpf;
	public LocalDateTime lastQuery;
	public FinancialMovement lastTransaction;
	public CreditCardTransaction lastCreditCardTransaction;
}
