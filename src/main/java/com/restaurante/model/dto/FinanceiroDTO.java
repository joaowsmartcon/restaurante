package com.restaurante.model.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.restaurante.model.Financeiro;

public class FinanceiroDTO {

	private Long id;
	private EmpresaPessoaDTO empresaPessoaDTO;
	private Date dataCadastro;
	private Date dataVencimento;
	private Date dataPagamento;
	private BigDecimal valorOriginal;
	private BigDecimal desconto;
	private BigDecimal acrescimo;
	private BigDecimal valorTotal;
	private BigDecimal valorPago;
	private TipoRecebimentoDTO tipoRecebimentoDTO;
	private TipoLancamentoDTO tipoLancamentoDTO;
	
	public static FinanceiroDTO convertFinanceiroToDTO(Financeiro financeiro) {
		FinanceiroDTO dto = new FinanceiroDTO();
		dto.setId(financeiro.getId());
		dto.setEmpresaPessoaDTO(EmpresaPessoaDTO.convertEmpresaPessoaToDTO(financeiro.getEmpresaPessoa()));
		dto.setDataCadastro(financeiro.getDataCadastro());
		dto.setDesconto(financeiro.getDesconto());
		dto.setValorTotal(financeiro.getValorTotal());
		dto.setAcrescimo(financeiro.getAcrescimo());
		dto.setDataPagamento(financeiro.getDataPagamento());
		dto.setDataVencimento(financeiro.getDataVencimento());
		dto.setTipoLancamentoDTO(TipoLancamentoDTO.convertTipoLancamentoToDTO(financeiro.getTipoLancamento()));
		dto.setTipoRecebimentoDTO(TipoRecebimentoDTO.convertTipoRecebimentoToDTO(financeiro.getTipoRecebimento()));
		dto.setValorOriginal(financeiro.getValorOriginal());
		dto.setValorPago(financeiro.getValorPago());
		dto.setValorTotal(financeiro.getValorTotal());
		return dto;
	}
	
	public static List<FinanceiroDTO> convertListToDTO(List<Financeiro> financeiros) {
		List<FinanceiroDTO> listDTOs = new ArrayList<>();
		listDTOs = financeiros.stream().map(financeiro -> {
			return convertFinanceiroToDTO(financeiro);
		}).collect(Collectors.toList());
		return listDTOs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmpresaPessoaDTO getEmpresaPessoaDTO() {
		return empresaPessoaDTO;
	}

	public void setEmpresaPessoaDTO(EmpresaPessoaDTO empresaPessoaDTO) {
		this.empresaPessoaDTO = empresaPessoaDTO;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(BigDecimal acrescimo) {
		this.acrescimo = acrescimo;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public TipoRecebimentoDTO getTipoRecebimentoDTO() {
		return tipoRecebimentoDTO;
	}

	public void setTipoRecebimentoDTO(TipoRecebimentoDTO tipoRecebimentoDTO) {
		this.tipoRecebimentoDTO = tipoRecebimentoDTO;
	}

	public TipoLancamentoDTO getTipoLancamentoDTO() {
		return tipoLancamentoDTO;
	}

	public void setTipoLancamentoDTO(TipoLancamentoDTO tipoLancamentoDTO) {
		this.tipoLancamentoDTO = tipoLancamentoDTO;
	}
}
