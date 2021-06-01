package com.restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.Convenio;
import com.restaurante.repository.ConvenioRepository;
import com.restaurante.service.ConvenioService;

@Service("convenioService")
public class ConvenioServiceImpl implements ConvenioService {

	@Autowired
	ConvenioRepository convenioRepository;
	
	@Override
	public List<Convenio> findAllConvenios() {
		try {
			List<Convenio> convenios = this.convenioRepository.findAll();
			return convenios;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Convenio findConvenio(String id) {
		try {
			Optional<Convenio> convenio =  this.convenioRepository.findById(Long.parseLong(id.toString()));
			if(convenio.isPresent()) {
				return convenio.get();
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void saveConvenio(Convenio convenio) {
		try {
			this.convenioRepository.save(convenio);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteConvenio(String id) {
		try {
			Optional<Convenio> convenio = this.convenioRepository.findById(Long.parseLong(id));
			if (convenio.isPresent())
				this.convenioRepository.delete(convenio.get());
		} catch (Exception e) {
			throw e;
		}
	}

}
