package com.restaurante.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "combo")
public class Combo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String nome;

	@Column(length = 200)
	private String descricao;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	String getNome() {
		return nome;
	}

	void setNome(String nome) {
		this.nome = nome;
	}

	String getDescricao() {
		return descricao;
	}

	void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	BigDecimal getValorTotal() {
		return valorTotal;
	}

	void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
