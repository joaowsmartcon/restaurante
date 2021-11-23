package com.restaurante.model;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.restaurante.model.dto.EmpresaPessoaDTO;
import com.restaurante.model.dto.FinanceiroDTO;
import com.restaurante.model.dto.TipoLancamentoDTO;
import com.restaurante.model.dto.TipoRecebimentoDTO;

public class FinanceiroDTOTest {
	
	private Financeiro financeiro = new Financeiro(1L, new EmpresaPessoa(), new Date(), new Date(), new Date(), BigDecimal.TEN, BigDecimal.TEN
			, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN, new TipoRecebimento(), new TipoLancamento());
	
	private FinanceiroDTO financeiroDTO = new FinanceiroDTO(1L, new EmpresaPessoaDTO(), new Date(), new Date(), new Date(), BigDecimal.TEN, BigDecimal.TEN
			, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN, new TipoRecebimentoDTO(), new TipoLancamentoDTO());
	
	@Test
	public void convertFinanceiroToDTOTest() {
		when(FinanceiroDTO.convertFinanceiroToDTO(financeiro)).thenReturn(financeiroDTO);
	}

}