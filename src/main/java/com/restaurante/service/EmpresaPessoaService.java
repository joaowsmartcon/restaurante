package com.restaurante.service;

import java.util.List;

import com.restaurante.model.EmpresaPessoa;

public interface EmpresaPessoaService {
	
	public List<EmpresaPessoa> findAllEmpresaPessoas();
	public EmpresaPessoa findEmpresaPessoa(String id);
	public void saveEmpresaPessoa(EmpresaPessoa empresaPessoa);
	public void deleteEmpresaPessoa(String id);
}
