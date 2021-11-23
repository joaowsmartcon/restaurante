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
import com.restaurante.model.dto.ComandaDTO;
import com.restaurante.service.ComandaService;

@RestController
@RequestMapping("/comanda")
public class ComandaController {
	
	@Autowired
	ComandaService comandaService;
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindComanda(@RequestParam(value="id", required=true) String id) {
		try {
			ComandaDTO comanda =  this.comandaService.findComanda(id);
			Gson gson = new Gson();
			String retorno = gson.toJson(comanda);
			if(comanda != null) {
				return new ResponseEntity<>(retorno, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> getSaveComanda(@RequestBody ComandaDTO comanda) {
		try {
			comanda.setDataCadastro(new Date());  
			this.comandaService.saveComanda(comanda);
			return new ResponseEntity<>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteComanda(@RequestParam(value="id", required=true) String id){
		try {
			this.comandaService.deleteComanda(id);
			return new ResponseEntity<>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
