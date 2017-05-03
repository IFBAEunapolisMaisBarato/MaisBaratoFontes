package br.edu.ifba.eunapolis.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
 
@Entity
public class PrecoProduto {
	
	@Id
	@GeneratedValue
	private long id;

	@NotNull
	@NotBlank
	@OneToOne
	private Produto produto;

	@NotNull
	@OneToOne
	private PontoVenda pontoVenda;

	@NotNull
	@NotEmpty
	private double preco;

	@NotNull
	@NotEmpty
	private Date data;
	
	@NotNull
	@NotEmpty
	@OneToOne
	private User user;
	
	@NotNull
	@DefaultValue(value = "false")
	private boolean valido;
	
	private int pontuacao;

	public long getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public PontoVenda getPontoVenda() {
		return pontoVenda;
	}

	public double getPreco() {
		return preco;
	}

	public Date getData() {
		return data;
	}

	public User getUser() {
		return user;
	}

	public boolean isValido() {
		return valido;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setPontoVenda(PontoVenda pontoVenda) {
		this.pontoVenda = pontoVenda;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}
