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
}
