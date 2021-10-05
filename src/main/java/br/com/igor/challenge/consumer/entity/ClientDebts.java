package br.com.igor.challenge.consumer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class ClientDebts {

	@Id
	public String cpf;
	public String name;
	public String address;

	@OneToMany(mappedBy = "clientDebts", cascade = CascadeType.ALL)
	public List<Debt> debts;
}
