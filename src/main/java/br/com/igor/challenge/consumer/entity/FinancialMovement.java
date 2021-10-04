package br.com.igor.challenge.consumer.entity;

import java.time.LocalDateTime;

import br.com.igor.challenge.consumer.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FinancialMovement {
	public TransactionType type;
	public LocalDateTime timestamp;
	public double value;
}
