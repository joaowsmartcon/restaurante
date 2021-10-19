package com.restaurante.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.Parcela;
import com.restaurante.repository.ParcelaRepository;
import com.restaurante.service.ParcelaService;

@Service("parcelaService")
public class ParcelaServiceImpl implements ParcelaService {

	@Autowired
	ParcelaRepository parcelaRepository;
	
	@Override
	public List<Parcela> findAllParcelas() {
		try {
			List<Parcela> parcelas = this.parcelaRepository.findAll();
			return parcelas;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Parcela findParcela(String id) {
		try {
			Optional<Parcela> parcela =  this.parcelaRepository.findById(Long.parseLong(id.toString()));
			if(parcela.isPresent()) {
				return parcela.get();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void saveParcela(Parcela parcela) {
		try {
			this.parcelaRepository.save(parcela);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteParcela(String id) {
		try {
			Optional<Parcela> parcela = this.parcelaRepository.findById(Long.parseLong(id));
			if (parcela.isPresent())
				this.parcelaRepository.delete(parcela.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
