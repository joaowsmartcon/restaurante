package com.restaurante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.restaurante.model.dto.TipoLancamentoDTO;

@Entity
@Table(name = "tipo_lancamento")
public class TipoLancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String descricao;

	public static TipoLancamento convertDTO(TipoLancamentoDTO dto) {
		TipoLancamento tipoLancamento = new TipoLancamento();
		tipoLancamento.setId(dto.getId());
		tipoLancamento.setDescricao(dto.getDescricao());
		return tipoLancamento;
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
