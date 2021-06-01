package com.restaurante.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "convenio")
public class Convenio {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(length = 200)
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idempresapessoa")
	private EmpresaPessoa empresaPessoa;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
	@Column(name = "data_vencimento")
	private Date dataVencimento;
	
	private boolean situacao;

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

	EmpresaPessoa getEmpresaPessoa() {
		return empresaPessoa;
	}

	void setEmpresaPessoa(EmpresaPessoa empresaPessoa) {
		this.empresaPessoa = empresaPessoa;
	}

	Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	Date getDataVencimento() {
		return dataVencimento;
	}

	void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	boolean isSituacao() {
		return situacao;
	}

	void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + ((empresaPessoa == null) ? 0 : empresaPessoa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (situacao ? 1231 : 1237);
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
		Convenio other = (Convenio) obj;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (situacao != other.situacao)
			return false;
		return true;
	}
}
