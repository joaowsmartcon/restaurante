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

import com.restaurante.model.dto.FinanceiroDTO;

@Entity
@Table(name = "financeiro")
public class Financeiro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idempresapessoa")
	private EmpresaPessoa empresaPessoa;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@Column(name = "data_vencimento")
	private Date dataVencimento;
	
	@Column(name = "data_pagamento")
	private Date dataPagamento;
	
	@Column(name = "valor_original", scale = 2)
	private BigDecimal valorOriginal;
	
	@Column(scale = 2)
	private BigDecimal desconto;
	
	@Column(scale = 2)
	private BigDecimal acrescimo;
	
	@Column(name = "valor_total", scale = 2)
	private BigDecimal valorTotal;
	
	@Column(name = "valor_pago", scale = 2)
	private BigDecimal valorPago;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idtipo_recebimento")
	private TipoRecebimento tipoRecebimento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idtipo_lancamento")
	private TipoLancamento tipoLancamento;
	
	public Financeiro() {
		
	}
	
	public Financeiro(Long id, EmpresaPessoa empresaPessoa, Date dataCadastro, Date dataVencimento, Date dataPagamento, BigDecimal valorOriginal
		, BigDecimal desconto, BigDecimal acrescimo, BigDecimal valorTotal, BigDecimal valorPago, TipoRecebimento tipoRecebimento, TipoLancamento tipoLancamento) {
		this.id = id;
		this.empresaPessoa = empresaPessoa;
		this.dataCadastro = dataCadastro;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.valorOriginal = valorOriginal;
		this.desconto = desconto;
		this.acrescimo = acrescimo;
		this.valorTotal = valorTotal;
		this.valorPago = valorPago;
		this.tipoRecebimento = tipoRecebimento;
		this.tipoLancamento = tipoLancamento;
	}
	
	public static Financeiro convertDTO(FinanceiroDTO dto) {
		Financeiro financeiro = new Financeiro();
		financeiro.setId(dto.getId());
		financeiro.setEmpresaPessoa(EmpresaPessoa.convertDTO(dto.getEmpresaPessoaDTO()));
		financeiro.setDataCadastro(dto.getDataCadastro());
		financeiro.setDesconto(dto.getDesconto());
		financeiro.setValorTotal(dto.getValorTotal());
		financeiro.setAcrescimo(dto.getAcrescimo());
		financeiro.setDataPagamento(dto.getDataPagamento());
		financeiro.setDataVencimento(dto.getDataVencimento());
		financeiro.setTipoLancamento(TipoLancamento.convertDTO(dto.getTipoLancamentoDTO()));
		financeiro.setTipoRecebimento(TipoRecebimento.convertDTO(dto.getTipoRecebimentoDTO()));
		financeiro.setValorOriginal(dto.getValorOriginal());
		financeiro.setValorPago(dto.getValorPago());
		financeiro.setValorTotal(dto.getValorTotal());
		return financeiro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmpresaPessoa getEmpresaPessoa() {
		return empresaPessoa;
	}

	public void setEmpresaPessoa(EmpresaPessoa empresaPessoa) {
		this.empresaPessoa = empresaPessoa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(BigDecimal acrescimo) {
		this.acrescimo = acrescimo;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public TipoRecebimento getTipoRecebimento() {
		return tipoRecebimento;
	}

	public void setTipoRecebimento(TipoRecebimento tipoRecebimento) {
		this.tipoRecebimento = tipoRecebimento;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

}
