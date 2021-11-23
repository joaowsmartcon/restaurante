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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public EmpresaPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EmpresaPessoa pessoa) {
		this.pessoa = pessoa;
	}

}
