package br.edu.ifba.eunapolis.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */

@Entity
public class PrecoProduto extends AbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@OneToOne
	private Produto produto;

	@NotNull
	@OneToOne
	private PontoVenda pontoVenda;

	@NotNull
	@DecimalMax("99999.999999")
	private Double preco;

	@NotNull
	@OneToOne
	private User user;

	private Boolean valido;

	private int pontuacao;
	
	@PrePersist
	public void setValido() {
		this.setValido(true);
	}
	public Long getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public PontoVenda getPontoVenda() {
		return pontoVenda;
	}

	public Double getPreco() {
		return preco;
	}

	public User getUser() {
		return user;
	}

	public Boolean getValido() {
		return valido;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setPontoVenda(PontoVenda pontoVenda) {
		this.pontoVenda = pontoVenda;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setValido(Boolean valido) {
		this.valido = valido;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	 
	
}
