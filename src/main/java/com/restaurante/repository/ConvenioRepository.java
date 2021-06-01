package com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.model.Convenio;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Long> {
	
}
