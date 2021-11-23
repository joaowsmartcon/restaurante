package com.restaurante.service;

import com.restaurante.model.dto.ComandaDTO;

public interface ComandaService {
	
	public ComandaDTO findComanda(String id);
	public void saveComanda(ComandaDTO comanda);
	public void deleteComanda(String id);
}
