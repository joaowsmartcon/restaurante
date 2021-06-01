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
import com.restaurante.model.Financeiro;
import com.restaurante.service.FinanceiroService;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {
	
	@Autowired
	FinanceiroService financeiroService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getFindAllFinanceiros(){
		try {
			List<Financeiro> financeiros = this.financeiroService.findAllFinanceiros();
			Gson gson = new Gson();
			String retorno = gson.toJson(financeiros);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindFinanceiro(@RequestParam(value="id", required=true) String id) {
		try {
			Financeiro financeiro =  this.financeiroService.findFinanceiro(id);
			Gson gson = new Gson();
			String retorno = gson.toJson(financeiro);
			if(financeiro != null) {
				return new ResponseEntity<String>(retorno, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> getSaveFinanceiro(@RequestBody Financeiro financeiro) {
		try {
			financeiro.setDataCadastro(new Date());  
			this.financeiroService.saveFinanceiro(financeiro);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteFinanceiro(@RequestParam(value="id", required=true) String id){
		try {
			this.financeiroService.deleteFinanceiro(id);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
