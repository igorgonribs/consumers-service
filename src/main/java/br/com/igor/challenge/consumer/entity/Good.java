package br.com.igor.challenge.consumer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Good {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public String description;
	public double value;

	@ManyToOne
	@JoinColumn(name = "clientgoodscpf")
	@JsonIgnore
	private ClientGoods clientGoods;
}
