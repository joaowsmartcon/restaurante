package com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.model.EmpresaPessoa;

@Repository
public interface EmpresaPessoaRepository extends JpaRepository<EmpresaPessoa, Long> {
	
}
