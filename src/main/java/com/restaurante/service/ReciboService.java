package com.restaurante.service;

import java.util.List;

import com.restaurante.model.Recibo;

public interface ReciboService {
	
	public List<Recibo> findAllRecibos();
	public Recibo findRecibo(String id);
	public void saveRecibo(Recibo recibo);
	public void deleteRecibo(String id);
}
