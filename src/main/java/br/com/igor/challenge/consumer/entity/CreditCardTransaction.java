package br.com.igor.challenge.consumer.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardTransaction {
	public LocalDateTime timestamp;
	public double value;

}
