package br.com.igor.challenge.consumer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Data
@JsonInclude(value = Include.NON_NULL)
public class ClientGoods {

	@Id
	public String cpf;
	public int age;
	public double income;
	public String address;
	
	@Transient
	public double patrimony;

	@OneToMany(mappedBy = "clientGoods", cascade = CascadeType.ALL)
	public List<Good> goods;
}
