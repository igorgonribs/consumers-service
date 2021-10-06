package br.com.igor.challenge.consumer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class ClientGoods {

	@Id
	public String cpf;
	public int age;
	public double income;
	public String address;

	@OneToMany(mappedBy = "clientGoods", cascade = CascadeType.ALL)
	public List<Good> goods;
}
