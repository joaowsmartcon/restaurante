package com.restaurante.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.model.Produto;
import com.restaurante.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class produtoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/listar")
	public List<Produto> findAllProducts(){
		try {
			return this.findAllProducts();
		} catch (Exception e) {
			return new ArrayList<Produto>();
		}
	}
	
}
