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
import com.restaurante.model.Parcela;
import com.restaurante.service.ParcelaService;

@RestController
@RequestMapping("/parcela")
public class ParcelaController {
	
	@Autowired
	ParcelaService parcelaService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getFindAllParcelas(){
		try {
			List<Parcela> parcelas = this.parcelaService.findAllParcelas();
			Gson gson = new Gson();
			String retorno = gson.toJson(parcelas);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindParcela(@RequestParam(value="id", required=true) String id) {
		try {
			Parcela parcela =  this.parcelaService.findParcela(id);
			Gson gson = new Gson();
			String retorno = gson.toJson(parcela);
			if(parcela != null) {
				return new ResponseEntity<String>(retorno, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> getSaveParcela(@RequestBody Parcela parcela) {
		try {
			parcela.setDataCadastro(new Date());  
			this.parcelaService.saveParcela(parcela);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteParcela(@RequestParam(value="id", required=true) String id){
		try {
			this.parcelaService.deleteParcela(id);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
