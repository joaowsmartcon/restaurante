package com.restaurante.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.restaurante.model.Comanda;
import com.restaurante.model.EmpresaPessoa;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ComandaControllerTest {

	@Autowired
	private MockMvc mockMvc;

//	@Test
//	public void saveShouldReturnStatusOK() throws Exception {
//		Comanda comanda = new Comanda(1L, new EmpresaPessoa(), new Date(), BigDecimal.TEN, BigDecimal.TEN);
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//		String requestJson = ow.writeValueAsString(comanda);
//		mockMvc.perform(post("/comanda/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
//				.andExpect(status().isOk());
//	}
//	
	@Test
	public void saveShouldReturnStatusError() throws Exception {
		mockMvc.perform(post("/comanda/save").contentType(MediaType.APPLICATION_JSON).content("Error"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void findByIdShouldReturnStatusError() throws Exception {
		mockMvc.perform(get("/comanda/find").queryParam("id", "null")).andExpect(status().isBadRequest());
	}

	@Test
	public void findByIdNotPresentsShouldReturnStatusError() throws Exception {
		mockMvc.perform(get("/comanda/find").queryParam("id", "10")).andExpect(status().isBadRequest());
	}

	@Test
	public void findByIdShouldReturnStatusOk() throws Exception {
		mockMvc.perform(get("/comanda/find").queryParam("id", "1")).andExpect(status().isOk());
	}

	@Test
	public void deleteShouldReturnStatusError() throws Exception {
		mockMvc.perform(delete("/comanda/delete").queryParam("id", "null")).andExpect(status().isBadRequest());
	}

//	    @Test
//	    public void deleteShouldReturnStatusOk() throws Exception {
//	        mockMvc.perform(delete("/comanda/delete")
//	        		.queryParam("id", "3"))
//	                .andExpect(status().isOk());
//	    }
}
