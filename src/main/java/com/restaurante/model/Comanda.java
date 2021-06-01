package com.restaurante.model;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "comanda")
public class Comanda {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idpessoa")
	private EmpresaPessoa pessoa;
	
	@Column(name = "data_cadastro")
	private Date dataCadast;
	
	private BigDecimal desconto;
	
	@Column(name = "valor_total", scale = 2)
	private BigDecimal valorTotal;

	Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	EmpresaPessoa getPessoa() {
		return pessoa;
	}

	void setPessoa(EmpresaPessoa pessoa) {
		this.pessoa = pessoa;
	}

	Date getDataCadast() {
		return dataCadast;
	}

	void setDataCadast(Date dataCadast) {
		this.dataCadast = dataCadast;
	}

	BigDecimal getDesconto() {
		return desconto;
	}

	void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	BigDecimal getValorTotal() {
		return valorTotal;
	}

	void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCadast == null) ? 0 : dataCadast.hashCode());
		result = prime * result + ((desconto == null) ? 0 : desconto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		Comanda other = (Comanda) obj;
		if (dataCadast == null) {
			if (other.dataCadast != null)
				return false;
		} else if (!dataCadast.equals(other.dataCadast))
			return false;
		if (desconto == null) {
			if (other.desconto != null)
				return false;
		} else if (!desconto.equals(other.desconto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}
}
