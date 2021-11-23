package com.restaurante.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.restaurante.model.EmpresaPessoa;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmpresaPessoaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void saveShouldReturnStatusOK() throws Exception {
		EmpresaPessoa pessoa = new EmpresaPessoa(1L, "João", "00000000000", new Date(), "a@a.com", "99999999999",
				new Date(), false);
		assertThat(pessoa.getId()).isNotNull();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(pessoa);
		mockMvc.perform(post("/empresa-pessoa/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isOk());
	}

	@Test
	public void saveShouldReturnStatusError() throws Exception {
		mockMvc.perform(post("/empresa-pessoa/save").contentType(MediaType.APPLICATION_JSON).content("Error"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void findByIdShouldReturnStatusError() throws Exception {
		mockMvc.perform(get("/empresa-pessoa/find").queryParam("id", "null")).andExpect(status().isBadRequest());
	}

	@Test
	public void findByIdNotPresentsShouldReturnStatusError() throws Exception {
		mockMvc.perform(get("/empresa-pessoa/find").queryParam("id", "10")).andExpect(status().isBadRequest());
	}

	@Test
	public void findByIdShouldReturnStatusOk() throws Exception {
		mockMvc.perform(get("/empresa-pessoa/find").queryParam("id", "4")).andExpect(status().isOk());
	}

	@Test
	public void deleteShouldReturnStatusError() throws Exception {
		mockMvc.perform(delete("/empresa-pessoa/delete").queryParam("id", "null")).andExpect(status().isBadRequest());
	}

	@Test
	public void deleteShouldReturnStatusOk() throws Exception {
		mockMvc.perform(delete("/empresa-pessoa/delete").queryParam("id", "1")).andExpect(status().isOk());
	}
}
