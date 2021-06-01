package com.restaurante.service;

import java.util.List;

import com.restaurante.model.Comanda;

public interface ComandaService {
	
	public List<Comanda> findAllComandas();
	public Comanda findComanda(String id);
	public void saveComanda(Comanda comanda);
	public void deleteComanda(String id);
}
