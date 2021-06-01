package com.restaurante.service;

import java.util.List;

import com.restaurante.model.Financeiro;

public interface FinanceiroService {
	
	public List<Financeiro> findAllFinanceiros();
	public Financeiro findFinanceiro(String id);
	public void saveFinanceiro(Financeiro financeiro);
	public void deleteFinanceiro(String id);
}
