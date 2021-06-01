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
import com.restaurante.model.Convenio;
import com.restaurante.service.ConvenioService;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {
	
	@Autowired
	ConvenioService convenioService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getFindAllConvenios(){
		try {
			List<Convenio> convenios = this.convenioService.findAllConvenios();
			Gson gson = new Gson();
			String retorno = gson.toJson(convenios);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindConvenio(@RequestParam(value="id", required=true) String id) {
		try {
			Convenio convenio =  this.convenioService.findConvenio(id);
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
	public ResponseEntity<String> getSaveConvenio(@RequestBody Convenio convenio) {
		try {
			convenio.setDataCadastro(new Date());  
			this.convenioService.saveConvenio(convenio);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteConvenio(@RequestParam(value="id", required=true) String id){
		try {
			this.convenioService.deleteConvenio(id);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
