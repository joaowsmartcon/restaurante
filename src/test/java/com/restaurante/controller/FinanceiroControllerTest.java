package com.restaurante.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.restaurante.model.dto.EmpresaPessoaDTO;
import com.restaurante.model.dto.FinanceiroDTO;
import com.restaurante.model.dto.TipoLancamentoDTO;
import com.restaurante.model.dto.TipoRecebimentoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FinanceiroControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void saveShouldReturnStatusOK() throws Exception {
		FinanceiroDTO financeiro = new FinanceiroDTO(1L, new EmpresaPessoaDTO(), new Date(), new Date(), new Date(), BigDecimal.TEN, BigDecimal.TEN
				, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN, new TipoRecebimentoDTO(), new TipoLancamentoDTO());
		assertThat(financeiro.getId()).isNotNull();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(financeiro);
		mockMvc.perform(post("/financeiro/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isOk());
	}

	@Test
	public void saveShouldReturnStatusError() throws Exception {
		mockMvc.perform(post("/financeiro/save").contentType(MediaType.APPLICATION_JSON).content("Error"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void findByIdShouldReturnStatusError() throws Exception {
		mockMvc.perform(get("/financeiro/find").queryParam("id", "null")).andExpect(status().isBadRequest());
	}

	@Test
	public void findByIdNotPresentsShouldReturnStatusError() throws Exception {
		mockMvc.perform(get("/financeiro/find").queryParam("id", "10")).andExpect(status().isBadRequest());
	}

	@Test
	public void findByIdShouldReturnStatusOk() throws Exception {
		mockMvc.perform(get("/financeiro/find").queryParam("id", "1")).andExpect(status().isOk());
	}

	@Test
	public void deleteShouldReturnStatusError() throws Exception {
		mockMvc.perform(delete("/financeiro/delete").queryParam("id", "null")).andExpect(status().isBadRequest());
	}

	@Test
	public void deleteShouldReturnStatusOk() throws Exception {
		mockMvc.perform(delete("/financeiro/delete").queryParam("id", "1")).andExpect(status().isOk());
	}
}
