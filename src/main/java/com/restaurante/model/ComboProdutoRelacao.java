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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((combo == null) ? 0 : combo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((qtde == null) ? 0 : qtde.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComboProdutoRelacao other = (ComboProdutoRelacao) obj;
		if (combo == null) {
			if (other.combo != null)
				return false;
		} else if (!combo.equals(other.combo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtde == null) {
			if (other.qtde != null)
				return false;
		} else if (!qtde.equals(other.qtde))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
