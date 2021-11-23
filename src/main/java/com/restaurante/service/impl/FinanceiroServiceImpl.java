package com.restaurante.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.Financeiro;
import com.restaurante.model.dto.FinanceiroDTO;
import com.restaurante.repository.FinanceiroRepository;
import com.restaurante.service.FinanceiroService;

@Service("financeiroService")
public class FinanceiroServiceImpl implements FinanceiroService {

	@Autowired
	FinanceiroRepository financeiroRepository;
	
	@Override
	public FinanceiroDTO findFinanceiro(String id) {
		try {
			Optional<Financeiro> financeiro =  this.financeiroRepository.findById(Long.parseLong(id.toString()));
			if(financeiro.isPresent()) {
				FinanceiroDTO dto = FinanceiroDTO.convertFinanceiroToDTO(financeiro.get());
				return dto;
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void saveFinanceiro(FinanceiroDTO financeiroDTO) {
		try {
			Financeiro financeiro = Financeiro.convertDTO(financeiroDTO);
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
