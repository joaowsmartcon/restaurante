package com.restaurante.dao;

import static org.assertj.core.api.Assertions.assertThat;

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
import com.restaurante.repository.EmpresaPessoaRepository;
import com.sun.el.parser.ParseException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmpresaPessoaRepositoryTest {

	@Autowired
	private EmpresaPessoaRepository pessoaRepository;

	@Rule
	public ExpectedException thown = ExpectedException.none();

	private EmpresaPessoa pessoa = new EmpresaPessoa(1L, "João", "00000000000",
			new Date(), "a@a.com", "99999999999", new Date(), false);

	@Test
	public void createdShouldPersistData() throws NumberFormatException, ParseException {
		this.pessoaRepository.save(this.pessoa);
		assertThat(this.pessoa.getId()).isNotNull();
		assertThat(this.pessoa.getNome()).isEqualTo("João");
		assertThat(this.pessoa.getNome()).isNotEqualTo("AS");
		assertThat(this.pessoa.getCpfCnpj()).isEqualTo("00000000000");
		assertThat(this.pessoa.getEmail()).isEqualTo("a@a.com");
		assertThat(this.pessoa.getTelefone()).isEqualTo("99999999999");
		assertThat(this.pessoa.isSituacao()).isFalse();
	}

	@Test
	public void deleteShouldRemoveData() {
		this.pessoaRepository.save(this.pessoa);
		this.pessoaRepository.delete(this.pessoa);
		assertThat(this.pessoaRepository.findById(this.pessoa.getId())).isEmpty();
	}

	@Test
	public void updateShouldChangeAndPersistData() {
		this.pessoaRepository.save(this.pessoa);
		this.pessoa.setSituacao(true);
		this.pessoa = this.pessoaRepository.save(this.pessoa);
		assertThat(this.pessoa.isSituacao()).isTrue();
	}

}
