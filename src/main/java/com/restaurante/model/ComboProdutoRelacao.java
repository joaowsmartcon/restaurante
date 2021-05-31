package com.restaurante.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "combo_produto_relacao")
public class ComboProdutoRelacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcombo")
	private Combo combo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproduto")
	private Produto produto;
	
	@Column
	private Integer qtde;
	
	@Column(scale = 2)
	private BigDecimal valor;

	Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	Combo getCombo() {
		return combo;
	}

	void setCombo(Combo combo) {
		this.combo = combo;
	}

	Produto getProduto() {
		return produto;
	}

	void setProduto(Produto produto) {
		this.produto = produto;
	}

	Integer getQtde() {
		return qtde;
	}

	void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	BigDecimal getValor() {
		return valor;
	}

	void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
