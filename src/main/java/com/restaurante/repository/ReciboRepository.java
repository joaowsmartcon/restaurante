package com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.model.Recibo;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {
	
}