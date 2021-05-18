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
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String descricao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idfinalidade")
	private Finalidade finalidade;

	@Column(length = 2)
	private String unidade;
	
	@Column(name = "custo_liquido")
	private BigDecimal custoLiquido;

	@Column(name = "custo_bruto")
	private BigDecimal custoBruto;
	
	@Column(name = "preco_venda")
	private BigDecimal precoVenda;
	
	private boolean inativo;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;

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

	Finalidade getFinalidade() {
		return finalidade;
	}

	void setFinalidade(Finalidade finalidade) {
		this.finalidade = finalidade;
	}

	String getUnidade() {
		return unidade;
	}

	void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	BigDecimal getCustoLiquido() {
		return custoLiquido;
	}

	void setCustoLiquido(BigDecimal custoLiquido) {
		this.custoLiquido = custoLiquido;
	}

	BigDecimal getCustoBruto() {
		return custoBruto;
	}

	void setCustoBruto(BigDecimal custoBruto) {
		this.custoBruto = custoBruto;
	}

	BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	boolean isInativo() {
		return inativo;
	}

	void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custoBruto == null) ? 0 : custoBruto.hashCode());
		result = prime * result + ((custoLiquido == null) ? 0 : custoLiquido.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((finalidade == null) ? 0 : finalidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (inativo ? 1231 : 1237);
		result = prime * result + ((precoVenda == null) ? 0 : precoVenda.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
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
		Produto other = (Produto) obj;
		if (custoBruto == null) {
			if (other.custoBruto != null)
				return false;
		} else if (!custoBruto.equals(other.custoBruto))
			return false;
		if (custoLiquido == null) {
			if (other.custoLiquido != null)
				return false;
		} else if (!custoLiquido.equals(other.custoLiquido))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (finalidade == null) {
			if (other.finalidade != null)
				return false;
		} else if (!finalidade.equals(other.finalidade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inativo != other.inativo)
			return false;
		if (precoVenda == null) {
			if (other.precoVenda != null)
				return false;
		} else if (!precoVenda.equals(other.precoVenda))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		return true;
	}

}
