package com.restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.Financeiro;
import com.restaurante.repository.FinanceiroRepository;
import com.restaurante.service.FinanceiroService;

@Service("financeiroService")
public class FinanceiroServiceImpl implements FinanceiroService {

	@Autowired
	FinanceiroRepository financeiroRepository;
	
	@Override
	public List<Financeiro> findAllFinanceiros() {
		try {
			List<Financeiro> financeiros = this.financeiroRepository.findAll();
			return financeiros;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Financeiro findFinanceiro(String id) {
		try {
			Optional<Financeiro> financeiro =  this.financeiroRepository.findById(Long.parseLong(id.toString()));
			if(financeiro.isPresent()) {
				return financeiro.get();
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void saveFinanceiro(Financeiro financeiro) {
		try {
			this.financeiroRepository.save(financeiro);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteFinanceiro(String id) {
		try {
			Optional<Financeiro> financeiro = this.financeiroRepository.findById(Long.parseLong(id));
			if (financeiro.isPresent())
				this.financeiroRepository.delete(financeiro.get());
		} catch (Exception e) {
			throw e;
		}
	}

}
