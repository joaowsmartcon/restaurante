package com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.model.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
	
}
