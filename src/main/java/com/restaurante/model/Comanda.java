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

import com.restaurante.model.dto.ComandaDTO;

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
	private Date dataCadastro;
	
	private BigDecimal desconto;
	
	@Column(name = "valor_total", scale = 2)
	private BigDecimal valorTotal;
	
	public Comanda(Long id, EmpresaPessoa pessoa, Date dataCadastro, BigDecimal desconto, BigDecimal valorTotal) {
		this.id = id;
		this.pessoa = pessoa;
		this.dataCadastro = dataCadastro;
		this.desconto = desconto;
		this.valorTotal = valorTotal;
	}
	
	public Comanda() {
	}
	
	public static Comanda convertDTO(ComandaDTO comandaDTO) {
		Comanda comanda = new Comanda();
		comanda.setId(comandaDTO.getId());
		comanda.setPessoa(EmpresaPessoa.convertDTO(comandaDTO.getPessoaDTO()));
		comanda.setDataCadastro(comandaDTO.getDataCadastro());
		comanda.setDesconto(comandaDTO.getDesconto());
		comanda.setValorTotal(comandaDTO.getValorTotal());
		return comanda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmpresaPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EmpresaPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
