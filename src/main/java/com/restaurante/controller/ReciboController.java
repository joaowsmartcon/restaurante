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
import com.restaurante.model.Recibo;
import com.restaurante.service.ReciboService;

@RestController
@RequestMapping("/recibo")
public class ReciboController {
	
	@Autowired
	ReciboService reciboService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getFindAllRecibos(){
		try {
			List<Recibo> recibos = this.reciboService.findAllRecibos();
			Gson gson = new Gson();
			String retorno = gson.toJson(recibos);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindRecibo(@RequestParam(value="id", required=true) String id) {
		try {
			Recibo recibo =  this.reciboService.findRecibo(id);
			Gson gson = new Gson();
			String retorno = gson.toJson(recibo);
			if(recibo != null) {
				return new ResponseEntity<String>(retorno, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> getSaveRecibo(@RequestBody Recibo recibo) {
		try {
			recibo.setDataCadastro(new Date());  
			this.reciboService.saveRecibo(recibo);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteRecibo(@RequestParam(value="id", required=true) String id){
		try {
			this.reciboService.deleteRecibo(id);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
