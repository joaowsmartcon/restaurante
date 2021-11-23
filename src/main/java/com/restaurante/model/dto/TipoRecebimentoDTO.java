package com.restaurante.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.restaurante.model.TipoRecebimento;

public class TipoRecebimentoDTO {
	
	private Long id;
	private String descricao;
	
	public static TipoRecebimentoDTO convertTipoRecebimentoToDTO(TipoRecebimento tipoRecebimento) {
		TipoRecebimentoDTO dto = new TipoRecebimentoDTO();
		dto.setId(tipoRecebimento.getId());
		dto.setDescricao(tipoRecebimento.getDescricao());
		return dto;
	}
	
	public static List<TipoRecebimentoDTO> convertListToDTO(List<TipoRecebimento> tipoRecebimentos) {
		return tipoRecebimentos.stream().map(tipoRecebimento ->  
			convertTipoRecebimentoToDTO(tipoRecebimento)).collect(Collectors.toList());
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
