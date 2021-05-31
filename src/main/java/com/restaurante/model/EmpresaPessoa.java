package com.restaurante.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa_pessoa")
public class EmpresaPessoa {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String nome;
	
	@Column(name = "cpf_cnpj", length = 150)
	private String cpfCnpj;
	
	@Column(name = "data_nasc")
	private Date dataNasc;
	
	@Column(length = 200)
	private String email;
	
	@Column(length = 20)
	private String telefone;
	
	@Column(name = "data_cadastro")
	private Date dataCadastro;
	
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

	String getCpfCnpj() {
		return cpfCnpj;
	}

	void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	Date getDataNasc() {
		return dataNasc;
	}

	void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	String getTelefone() {
		return telefone;
	}

	void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	Date getDataCadastro() {
		return dataCadastro;
	}

	void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	boolean isSituacao() {
		return situacao;
	}

	void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
}
