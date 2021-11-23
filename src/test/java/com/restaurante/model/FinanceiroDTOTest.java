package com.restaurante.model;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

public class FinanceiroDTOTest {
	
	private Financeiro financeiro = new Financeiro(1L, new EmpresaPessoa(), new Date(), new Date(), new Date(), BigDecimal.TEN, BigDecimal.TEN
			, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN, new TipoRecebimento(), new TipoLancamento());
	
	@Test
	public void convertFinanceiroToDTOTest() {
		Financeiro
	}

}
