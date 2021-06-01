package com.restaurante.service;

import java.util.List;

import com.restaurante.model.Convenio;

public interface ConvenioService {
	
	public List<Convenio> findAllConvenios();
	public Convenio findConvenio(String id);
	public void saveConvenio(Convenio convenio);
	public void deleteConvenio(String id);
}
