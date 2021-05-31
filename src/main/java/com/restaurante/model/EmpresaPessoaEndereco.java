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
}
