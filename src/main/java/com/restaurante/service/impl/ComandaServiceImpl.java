package com.restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.Comanda;
import com.restaurante.repository.ComandaRepository;
import com.restaurante.service.ComandaService;

@Service("comandaService")
public class ComandaServiceImpl implements ComandaService {

	@Autowired
	ComandaRepository comandaRepository;
	
	@Override
	public List<Comanda> findAllComandas() {
		try {
			List<Comanda> comandas = this.comandaRepository.findAll();
			return comandas;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Comanda findComanda(String id) {
		try {
			Optional<Comanda> comanda =  this.comandaRepository.findById(Long.parseLong(id.toString()));
			if(comanda.isPresent()) {
				return comanda.get();
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void saveComanda(Comanda comanda) {
		try {
			this.comandaRepository.save(comanda);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteComanda(String id) {
		try {
			Optional<Comanda> comanda = this.comandaRepository.findById(Long.parseLong(id));
			if (comanda.isPresent())
				this.comandaRepository.delete(comanda.get());
		} catch (Exception e) {
			throw e;
		}
	}

}
