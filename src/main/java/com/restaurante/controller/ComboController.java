package com.restaurante.controller;

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
import com.restaurante.model.Combo;
import com.restaurante.service.ComboService;

@RestController
@RequestMapping("/combo")
public class ComboController {
	
	@Autowired
	ComboService comboService;
	
	@GetMapping("/all")
	public ResponseEntity<String> getFindAllCombos(){
		try {
			List<Combo> combos = this.comboService.findAllCombos();
			Gson gson = new Gson();
			String retorno = gson.toJson(combos);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/find")
	public ResponseEntity<String> getFindCombo(@RequestParam(value="id", required=true) String id) {
		try {
			Combo combo =  this.comboService.findCombo(id);
			Gson gson = new Gson();
			String retorno = gson.toJson(combo);
			if(combo != null) {
				return new ResponseEntity<String>(retorno, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<String> getSaveCombo(@RequestBody Combo combo) {
		try {
			this.comboService.saveCombo(combo);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> getDeleteCombo(@RequestParam(value="id", required=true) String id){
		try {
			this.comboService.deleteCombo(id);
			return new ResponseEntity<String>("Sucess!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
