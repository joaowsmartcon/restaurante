package com.restaurante.service;

import com.restaurante.model.dto.EmpresaPessoaDTO;

public interface EmpresaPessoaService {
	
	public EmpresaPessoaDTO findEmpresaPessoa(String id);
	public void saveEmpresaPessoa(EmpresaPessoaDTO empresaPessoa);
	public void deleteEmpresaPessoa(String id);
}
