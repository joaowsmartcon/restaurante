package com.restaurante.controller;

import java.util.Date;

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
import com.restaurante.model.dto.FinanceiroDTO;
import com.restaurante.service.FinanceiroService;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {
	
	@Autowired
	FinanceiroService financeiroService;
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindFinanceiro(@RequestParam(value="id", required=true) String id) {
		try {
			FinanceiroDTO financeiro =  this.financeiroService.findFinanceiro(id);
			Gson gson = new Gson();
			String retorno = gson.toJson(financeiro);
			if(financeiro != null) {
				return new ResponseEntity<>(retorno, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> getSaveFinanceiro(@RequestBody FinanceiroDTO financeiro) {
		try {
			financeiro.setDataCadastro(new Date());  
			this.financeiroService.saveFinanceiro(financeiro);
			return new ResponseEntity<>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteFinanceiro(@RequestParam(value="id", required=true) String id){
		try {
			this.financeiroService.deleteFinanceiro(id);
			return new ResponseEntity<>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
