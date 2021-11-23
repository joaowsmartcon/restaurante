package com.restaurante.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.restaurante.model.TipoLancamento;

public class TipoLancamentoDTO {
	
	private Long id;
	private String descricao;
	
	public static TipoLancamentoDTO convertTipoLancamentoToDTO(TipoLancamento tipoLancamento) {
		TipoLancamentoDTO dto = new TipoLancamentoDTO();
		dto.setId(tipoLancamento.getId());
		dto.setDescricao(tipoLancamento.getDescricao());
		return dto;
	}
	
	public static List<TipoLancamentoDTO> convertListToDTO(List<TipoLancamento> tipoLancamentos) {
		List<TipoLancamentoDTO> listDTOs = new ArrayList<>();
		listDTOs = tipoLancamentos.stream().map(tipoLancamento -> {
			return convertTipoLancamentoToDTO(tipoLancamento);
		}).collect(Collectors.toList());
		return listDTOs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
