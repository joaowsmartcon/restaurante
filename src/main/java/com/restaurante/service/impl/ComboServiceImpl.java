package com.restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.Combo;
import com.restaurante.repository.ComboRepository;
import com.restaurante.service.ComboService;

@Service("comboService")
public class ComboServiceImpl implements ComboService {

	@Autowired
	ComboRepository comboRepository;
	
	@Override
	public List<Combo> findAllCombos() {
		try {
			List<Combo> combos = this.comboRepository.findAll();
			return combos;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Combo findCombo(String id) {
		try {
			Optional<Combo> combo =  this.comboRepository.findById(Long.parseLong(id.toString()));
			if(combo.isPresent()) {
				return combo.get();
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void saveCombo(Combo combo) {
		try {
			this.comboRepository.save(combo);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteCombo(String id) {
		try {
			Optional<Combo> combo = this.comboRepository.findById(Long.parseLong(id));
			if (combo.isPresent())
				this.comboRepository.delete(combo.get());
		} catch (Exception e) {
			throw e;
		}
	}

}
