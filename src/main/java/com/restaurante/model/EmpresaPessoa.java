package com.restaurante.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.restaurante.model.dto.EmpresaPessoaDTO;

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
	
	public EmpresaPessoa() {
		
	}
	
	public EmpresaPessoa(Long id, String nome, String cpfCnpj, Date dataNasc, String email, String telefone, 
			Date dataCadastro, boolean situacao) {
		this.id = id;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.dataNasc = dataNasc;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.situacao = situacao;
	}
	
	public static EmpresaPessoa convertDTO(EmpresaPessoaDTO empresaPessoaDTO) {
		EmpresaPessoa empresa = new EmpresaPessoa();
		empresa.setId(empresaPessoaDTO.getId());
		empresa.setDataCadastro(empresaPessoaDTO.getDataCadastro());
		empresa.setCpfCnpj(empresaPessoaDTO.getCpfCnpj());
		empresa.setDataNasc(empresaPessoaDTO.getDataNasc());
		empresa.setEmail(empresaPessoaDTO.getEmail());
		empresa.setNome(empresaPessoaDTO.getNome());
		empresa.setSituacao(empresaPessoaDTO.isSituacao());
		empresa.setTelefone(empresaPessoaDTO.getTelefone());
		return empresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

}
