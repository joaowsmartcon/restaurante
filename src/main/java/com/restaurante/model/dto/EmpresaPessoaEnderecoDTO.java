package com.restaurante.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.restaurante.model.EmpresaPessoaEndereco;

public class EmpresaPessoaEnderecoDTO {

	private Long id;
	private String endereco;
	private String cidade;
	private String uf;
	private String bairro;
	private String numero;
	private EmpresaPessoaDTO pessoaDTO;
	
	public static EmpresaPessoaEnderecoDTO convertEmpresaPessoaEnderecoToDTO(EmpresaPessoaEndereco endereco) {
		EmpresaPessoaEnderecoDTO dto = new EmpresaPessoaEnderecoDTO();
		dto.setId(endereco.getId());
		dto.setPessoaDTO(EmpresaPessoaDTO.convertEmpresaPessoaToDTO(endereco.getPessoa()));
		dto.setBairro(endereco.getBairro());
		dto.setCidade(endereco.getCidade());
		dto.setEndereco(endereco.getEndereco());
		dto.setNumero(endereco.getNumero());
		dto.setUf(endereco.getUf());
		return dto;
	}
	
	public static List<EmpresaPessoaEnderecoDTO> convertListToDTO(List<EmpresaPessoaEndereco> enderecos) {
		List<EmpresaPessoaEnderecoDTO> listDTOs = new ArrayList<>();
		listDTOs = enderecos.stream().map(endereco -> {
			return convertEmpresaPessoaEnderecoToDTO(endereco);
		}).collect(Collectors.toList());
		return listDTOs;
	}

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

	public EmpresaPessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}

	public void setPessoaDTO(EmpresaPessoaDTO pessoaDTO) {
		this.pessoaDTO = pessoaDTO;
	}
}
