package com.restaurante.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.EmpresaPessoa;
import com.restaurante.model.dto.EmpresaPessoaDTO;
import com.restaurante.repository.EmpresaPessoaRepository;
import com.restaurante.service.EmpresaPessoaService;

@Service("empresaPessoaService")
public class EmpresaPessoaServiceImpl implements EmpresaPessoaService {

	@Autowired
	EmpresaPessoaRepository empresaPessoaRepository;

	@Override
	public EmpresaPessoaDTO findEmpresaPessoa(String id) {
		try {
			Optional<EmpresaPessoa> empresaPessoa =  this.empresaPessoaRepository.findById(Long.parseLong(id.toString()));
			if(empresaPessoa.isPresent()) {
				EmpresaPessoaDTO dto = EmpresaPessoaDTO.convertEmpresaPessoaToDTO(empresaPessoa.get());
				return dto;
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void saveEmpresaPessoa(EmpresaPessoaDTO empresaPessoaDTO) {
		try {
			EmpresaPessoa empresaPessoa = EmpresaPessoa.convertDTO(empresaPessoaDTO);
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
