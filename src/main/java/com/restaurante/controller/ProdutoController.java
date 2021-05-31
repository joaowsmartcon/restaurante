package com.restaurante.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.restaurante.model.Produto;
import com.restaurante.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getFindAllProducts(){
		try {
			List<Produto> produtos = this.produtoService.findAllProducts();
			Gson gson = new Gson();
			String retorno = gson.toJson(produtos);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindProduto(@RequestParam(value="id", required=true) String id) {
		try {
			Produto produto =  this.produtoService.findProduto(id);
			Gson gson = new Gson();
			String retorno = gson.toJson(produto);
			if(produto != null) {
				return new ResponseEntity<String>(retorno, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> getSaveProduto(@RequestBody Produto produto) {
		try {
			produto.setDataCadastro(new Date());  
			this.produtoService.saveProduto(produto);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteProduto(@RequestParam(value="id", required=true) String id){
		try {
			this.produtoService.deleteProduto(id);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
