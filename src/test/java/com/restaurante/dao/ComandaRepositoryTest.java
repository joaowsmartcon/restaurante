package com.restaurante.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.restaurante.model.Comanda;
import com.restaurante.model.EmpresaPessoa;
import com.restaurante.repository.ComandaRepository;
import com.sun.el.parser.ParseException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComandaRepositoryTest {

	@Autowired
	private ComandaRepository comandaRepository;

	@Rule
	public ExpectedException thown = ExpectedException.none();

	private Comanda comanda = new Comanda(null, new EmpresaPessoa(), new Date(),
			BigDecimal.TEN, BigDecimal.TEN);

	@Test
	public void createdShouldPersistData() throws NumberFormatException, ParseException {
		this.comandaRepository.save(this.comanda);
		assertThat(this.comanda.getId()).isNotNull();
		assertThat(this.comanda.getDesconto()).isEqualTo(BigDecimal.TEN);
		assertThat(this.comanda.getPessoa()).isNotNull();
		assertThat(this.comanda.getPessoa().getId()).isGreaterThan(Long.parseLong("0"));
		assertThat(this.comanda.getValorTotal()).isEqualTo(BigDecimal.TEN);
	}

	@Test
	public void deleteShouldRemoveData() {
		this.comandaRepository.save(this.comanda);
		this.comandaRepository.delete(this.comanda);
		assertThat(this.comandaRepository.findById(this.comanda.getId())).isEmpty();
	}

	@Test
	public void updateShouldChangeAndPersistData() {
		this.comandaRepository.save(this.comanda);
		this.comanda.setDataCadastro(new Date());
		this.comanda.setDesconto(BigDecimal.ONE);
		this.comanda = this.comandaRepository.save(this.comanda);
		assertThat(this.comanda.getDesconto()).isEqualTo(BigDecimal.ONE);
	}

}
