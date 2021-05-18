package com.restaurante.service;

import java.util.List;

import com.restaurante.model.Produto;

public interface ProdutoService {
	
	public List<Produto> findAllProducts();
	public Produto findProduto(String id);
	public void saveProduto(Produto produto);
	public void deleteProduto(String id);
}
