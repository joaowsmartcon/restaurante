package com.restaurante.model;

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
@Table(name = "empresa_pessoa_endereco")
public class EmpresaPessoaEndereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String endereco;

	@Column(length = 200)
	private String cidade;

	@Column(length = 2)
	private String uf;
	
	@Column(length = 200)
	private String bairro;

	@Column(length = 200)
	private String numero;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idempresapessa")
	private EmpresaPessoa pessoa;

	Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	String getEndereco() {
		return endereco;
	}

	void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	String getCidade() {
		return cidade;
	}

	void setCidade(String cidade) {
		this.cidade = cidade;
	}

	String getUf() {
		return uf;
	}

	void setUf(String uf) {
		this.uf = uf;
	}

	String getBairro() {
		return bairro;
	}

	void setBairro(String bairro) {
		this.bairro = bairro;
	}

	String getNumero() {
		return numero;
	}

	void setNumero(String numero) {
		this.numero = numero;
	}

	EmpresaPessoa getPessoa() {
		return pessoa;
	}

	void setPessoa(EmpresaPessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		EmpresaPessoaEndereco other = (EmpresaPessoaEndereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
}
