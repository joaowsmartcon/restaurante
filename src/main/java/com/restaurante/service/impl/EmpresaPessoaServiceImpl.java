package com.restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.EmpresaPessoa;
import com.restaurante.repository.EmpresaPessoaRepository;
import com.restaurante.service.EmpresaPessoaService;

@Service("empresaPessoaService")
public class EmpresaPessoaServiceImpl implements EmpresaPessoaService {

	@Autowired
	EmpresaPessoaRepository empresaPessoaRepository;
	
	@Override
	public List<EmpresaPessoa> findAllEmpresaPessoas() {
		try {
			List<EmpresaPessoa> empresaPessoas = this.empresaPessoaRepository.findAll();
			return empresaPessoas;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public EmpresaPessoa findEmpresaPessoa(String id) {
		try {
			Optional<EmpresaPessoa> empresaPessoa =  this.empresaPessoaRepository.findById(Long.parseLong(id.toString()));
			if(empresaPessoa.isPresent()) {
				return empresaPessoa.get();
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void saveEmpresaPessoa(EmpresaPessoa empresaPessoa) {
		try {
			this.empresaPessoaRepository.save(empresaPessoa);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteEmpresaPessoa(String id) {
		try {
			Optional<EmpresaPessoa> empresaPessoa = this.empresaPessoaRepository.findById(Long.parseLong(id));
			if (empresaPessoa.isPresent())
				this.empresaPessoaRepository.delete(empresaPessoa.get());
		} catch (Exception e) {
			throw e;
		}
	}

}
