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
import com.restaurante.model.dto.EmpresaPessoaDTO;
import com.restaurante.service.EmpresaPessoaService;

@RestController
@RequestMapping("/empresa-pessoa")
public class EmpresaPessoaController {
	
	@Autowired
	EmpresaPessoaService empresaPessoaService;
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindEmpresaPessoa(@RequestParam(value="id", required=true) String id) {
		try {
			EmpresaPessoaDTO empresaPessoa =  this.empresaPessoaService.findEmpresaPessoa(id);
			Gson gson = new Gson();
			String retorno = gson.toJson(empresaPessoa);
			if(empresaPessoa != null) {
				return new ResponseEntity<>(retorno, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> getSaveEmpresaPessoa(@RequestBody EmpresaPessoaDTO empresaPessoa) {
		try {
			empresaPessoa.setDataCadastro(new Date());  
			this.empresaPessoaService.saveEmpresaPessoa(empresaPessoa);
			return new ResponseEntity<>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteEmpresaPessoa(@RequestParam(value="id", required=true) String id){
		try {
			this.empresaPessoaService.deleteEmpresaPessoa(id);
			return new ResponseEntity<>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
