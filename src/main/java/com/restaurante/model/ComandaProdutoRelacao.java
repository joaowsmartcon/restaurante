package com.restaurante.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comanda_produto_relacao")
public class ComandaProdutoRelacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproduto")
	private Produto produto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcomanda")
	private Comanda comanda;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcombo")
	private Combo combo;
	
	@Column
	private Integer qtde;
	
	@Column(name = "valor_unitario", scale = 2)
	private BigDecimal valor;

}
