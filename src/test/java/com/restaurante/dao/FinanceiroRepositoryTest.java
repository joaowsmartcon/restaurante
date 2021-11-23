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

import com.restaurante.model.EmpresaPessoa;
import com.restaurante.model.Financeiro;
import com.restaurante.model.TipoLancamento;
import com.restaurante.model.TipoRecebimento;
import com.restaurante.repository.FinanceiroRepository;
import com.sun.el.parser.ParseException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FinanceiroRepositoryTest {

	@Autowired
	private FinanceiroRepository financeiroRepository;

	@Rule
	public ExpectedException thown = ExpectedException.none();

	private Financeiro financeiro = new Financeiro(1L, new EmpresaPessoa(), new Date(), new Date(), new Date(), BigDecimal.TEN, BigDecimal.TEN
			, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN, new TipoRecebimento(), new TipoLancamento());

	@Test
	public void createdShouldPersistData() throws NumberFormatException, ParseException {
		this.financeiroRepository.save(this.financeiro);
//		assertThat(this.financeiro.getId()).isNotNull();
//		assertThat(this.financeiro.getDesconto()).isEqualTo(BigDecimal.TEN);
//		assertThat(this.financeiro.getValorTotal()).isEqualTo(BigDecimal.TEN);
	}

	@Test
	public void deleteShouldRemoveData() {
		this.financeiroRepository.save(this.financeiro);
		this.financeiroRepository.delete(this.financeiro);
		assertThat(this.financeiroRepository.findById(this.financeiro.getId())).isEmpty();
	}

	@Test
	public void updateShouldChangeAndPersistData() {
		this.financeiroRepository.save(this.financeiro);
		this.financeiro.setDataCadastro(new Date());
		this.financeiro.setDesconto(BigDecimal.ONE);
		this.financeiro = this.financeiroRepository.save(this.financeiro);
//		assertThat(this.financeiro.getDesconto()).isEqualTo(BigDecimal.ONE);
	}

}
