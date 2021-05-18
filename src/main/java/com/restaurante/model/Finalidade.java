package com.restaurante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "finalidade")
public class Finalidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String descricao;

	Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	String getDescricao() {
		return descricao;
	}

	void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
