package com.restaurante.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.restaurante.model.EmpresaPessoa;

public class EmpresaPessoaDTO {
	 
	private Long id;
	private String nome;
	private String cpfCnpj;
	private Date dataNasc;
	private String email;
	private String telefone;
	private Date dataCadastro;
	private boolean situacao;
	
	public static EmpresaPessoaDTO convertEmpresaPessoaToDTO(EmpresaPessoa empresaPessoa) {
		EmpresaPessoaDTO dto = new EmpresaPessoaDTO();
		dto.setId(empresaPessoa.getId());
		dto.setDataCadastro(empresaPessoa.getDataCadastro());
		dto.setCpfCnpj(empresaPessoa.getCpfCnpj());
		dto.setDataNasc(empresaPessoa.getDataNasc());
		dto.setEmail(empresaPessoa.getEmail());
		dto.setNome(empresaPessoa.getNome());
		dto.setSituacao(empresaPessoa.isSituacao());
		dto.setTelefone(empresaPessoa.getTelefone());
		return dto;
	}
	
	public static List<EmpresaPessoaDTO> convertListToDTO(List<EmpresaPessoa> empresaPessoas) {
		List<EmpresaPessoaDTO> listDTOs = new ArrayList<>();
		listDTOs = empresaPessoas.stream().map(empresaPessoa -> {
			return convertEmpresaPessoaToDTO(empresaPessoa);
		}).collect(Collectors.toList());
		return listDTOs;
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
