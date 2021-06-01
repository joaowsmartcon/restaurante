package com.restaurante.service;

import java.util.List;

import com.restaurante.model.Combo;

public interface ComboService {
	
	public List<Combo> findAllCombos();
	public Combo findCombo(String id);
	public void saveCombo(Combo combo);
	public void deleteCombo(String id);
}
