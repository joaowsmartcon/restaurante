package com.restaurante.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.model.Produto;
import com.restaurante.repository.ProdutoRepository;
import com.restaurante.service.ProdutoService;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Override
	public List<Produto> findAllProdutos() {
		try {
			List<Produto> produtos = this.produtoRepository.findAll();
			return produtos;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Produto findProduto(String id) {
		try {
			Optional<Produto> produto =  this.produtoRepository.findById(Long.parseLong(id.toString()));
			if(produto.isPresent()) {
				return produto.get();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void saveProduto(Produto produto) {
		try {
			this.produtoRepository.save(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduto(String id) {
		try {
			Optional<Produto> produto = this.produtoRepository.findById(Long.parseLong(id));
			if (produto.isPresent())
				this.produtoRepository.delete(produto.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
