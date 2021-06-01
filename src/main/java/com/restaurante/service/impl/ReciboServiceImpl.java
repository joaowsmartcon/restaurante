package com.restaurante.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.Recibo;
import com.restaurante.repository.ReciboRepository;
import com.restaurante.service.ReciboService;

@Service("reciboService")
public class ReciboServiceImpl implements ReciboService {

	@Autowired
	ReciboRepository reciboRepository;
	
	@Override
	public List<Recibo> findAllRecibos() {
		try {
			List<Recibo> recibos = this.reciboRepository.findAll();
			return recibos;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Recibo findRecibo(String id) {
		try {
			Optional<Recibo> recibo =  this.reciboRepository.findById(Long.parseLong(id.toString()));
			if(recibo.isPresent()) {
				return recibo.get();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void saveRecibo(Recibo recibo) {
		try {
			this.reciboRepository.save(recibo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRecibo(String id) {
		try {
			Optional<Recibo> recibo = this.reciboRepository.findById(Long.parseLong(id));
			if (recibo.isPresent())
				this.reciboRepository.delete(recibo.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
