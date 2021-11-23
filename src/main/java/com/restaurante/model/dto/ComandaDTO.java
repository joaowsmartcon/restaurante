package com.restaurante.model.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.restaurante.model.Comanda;

public class ComandaDTO {

	private Long id;
	private EmpresaPessoaDTO pessoaDTO;
	private Date dataCadastro;
	private BigDecimal desconto;
	private BigDecimal valorTotal;
	
	public static ComandaDTO convertComandaToDTO(Comanda comanda) {
		ComandaDTO dto = new ComandaDTO();
		dto.setId(comanda.getId());
		dto.setPessoaDTO(EmpresaPessoaDTO.convertEmpresaPessoaToDTO(comanda.getPessoa()));
		dto.setDataCadastro(comanda.getDataCadastro());
		dto.setDesconto(comanda.getDesconto());
		dto.setValorTotal(comanda.getValorTotal());
		return dto;
	}
	
	public static List<ComandaDTO> convertListToDTO(List<Comanda> comandas) {
		List<ComandaDTO> listDTOs = new ArrayList<>();
		listDTOs = comandas.stream().map(comanda -> {
			return convertComandaToDTO(comanda);
		}).collect(Collectors.toList());
		return listDTOs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmpresaPessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}

	public void setPessoaDTO(EmpresaPessoaDTO pessoaDTO) {
		this.pessoaDTO = pessoaDTO;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
