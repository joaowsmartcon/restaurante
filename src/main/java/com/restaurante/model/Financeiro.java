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
	private TipoRecebimento tipoLancamento;

	Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	EmpresaPessoa getEmpresaPessoa() {
		return empresaPessoa;
	}

	void setEmpresaPessoa(EmpresaPessoa empresaPessoa) {
		this.empresaPessoa = empresaPessoa;
	}

	Date getDataCadastro() {
		return dataCadastro;
	}

	void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	Date getDataVencimento() {
		return dataVencimento;
	}

	void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	Date getDataPagamento() {
		return dataPagamento;
	}

	void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	BigDecimal getValorOriginal() {
		return valorOriginal;
	}

	void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	BigDecimal getDesconto() {
		return desconto;
	}

	void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	BigDecimal getAcrescimo() {
		return acrescimo;
	}

	void setAcrescimo(BigDecimal acrescimo) {
		this.acrescimo = acrescimo;
	}

	BigDecimal getValorTotal() {
		return valorTotal;
	}

	void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	BigDecimal getValorPago() {
		return valorPago;
	}

	void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	TipoRecebimento getTipoRecebimento() {
		return tipoRecebimento;
	}

	void setTipoRecebimento(TipoRecebimento tipoRecebimento) {
		this.tipoRecebimento = tipoRecebimento;
	}

	TipoRecebimento getTipoLancamento() {
		return tipoLancamento;
	}

	void setTipoLancamento(TipoRecebimento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acrescimo == null) ? 0 : acrescimo.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + ((desconto == null) ? 0 : desconto.hashCode());
		result = prime * result + ((empresaPessoa == null) ? 0 : empresaPessoa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipoLancamento == null) ? 0 : tipoLancamento.hashCode());
		result = prime * result + ((tipoRecebimento == null) ? 0 : tipoRecebimento.hashCode());
		result = prime * result + ((valorOriginal == null) ? 0 : valorOriginal.hashCode());
		result = prime * result + ((valorPago == null) ? 0 : valorPago.hashCode());
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
		Financeiro other = (Financeiro) obj;
		if (acrescimo == null) {
			if (other.acrescimo != null)
				return false;
		} else if (!acrescimo.equals(other.acrescimo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataPagamento == null) {
			if (other.dataPagamento != null)
				return false;
		} else if (!dataPagamento.equals(other.dataPagamento))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (desconto == null) {
			if (other.desconto != null)
				return false;
		} else if (!desconto.equals(other.desconto))
			return false;
		if (empresaPessoa == null) {
			if (other.empresaPessoa != null)
				return false;
		} else if (!empresaPessoa.equals(other.empresaPessoa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipoLancamento == null) {
			if (other.tipoLancamento != null)
				return false;
		} else if (!tipoLancamento.equals(other.tipoLancamento))
			return false;
		if (tipoRecebimento == null) {
			if (other.tipoRecebimento != null)
				return false;
		} else if (!tipoRecebimento.equals(other.tipoRecebimento))
			return false;
		if (valorOriginal == null) {
			if (other.valorOriginal != null)
				return false;
		} else if (!valorOriginal.equals(other.valorOriginal))
			return false;
		if (valorPago == null) {
			if (other.valorPago != null)
				return false;
		} else if (!valorPago.equals(other.valorPago))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}
}
