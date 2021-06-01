package com.restaurante.service;

import java.util.List;

import com.restaurante.model.Parcela;

public interface ParcelaService {
	
	public List<Parcela> findAllParcelas();
	public Parcela findParcela(String id);
	public void saveParcela(Parcela parcela);
	public void deleteParcela(String id);
}
