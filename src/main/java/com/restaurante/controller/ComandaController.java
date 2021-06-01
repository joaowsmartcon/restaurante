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
import com.restaurante.model.Comanda;
import com.restaurante.service.ComandaService;

@RestController
@RequestMapping("/convenio")
public class ComandaController {
	
	@Autowired
	ComandaService convenioService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getFindAllComandas(){
		try {
			List<Comanda> convenios = this.convenioService.findAllComandas();
			Gson gson = new Gson();
			String retorno = gson.toJson(convenios);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindComanda(@RequestParam(value="id", required=true) String id) {
		try {
			Comanda convenio =  this.convenioService.findComanda(id);
			Gson gson = new Gson();
			String retorno = gson.toJson(convenio);
			if(convenio != null) {
				return new ResponseEntity<String>(retorno, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> getSaveComanda(@RequestBody Comanda convenio) {
		try {
			convenio.setDataCadastro(new Date());  
			this.convenioService.saveComanda(convenio);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteComanda(@RequestParam(value="id", required=true) String id){
		try {
			this.convenioService.deleteComanda(id);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
