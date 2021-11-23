package com.restaurante.service;

import com.restaurante.model.dto.FinanceiroDTO;

public interface FinanceiroService {
	
	public FinanceiroDTO findFinanceiro(String id);
	public void saveFinanceiro(FinanceiroDTO financeiro);
	public void deleteFinanceiro(String id);
}
