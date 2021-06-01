package com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.model.Combo;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {
	
}
