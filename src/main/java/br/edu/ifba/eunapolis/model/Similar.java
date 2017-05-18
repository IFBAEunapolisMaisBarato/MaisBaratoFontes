package br.edu.ifba.eunapolis.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Similar extends AbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@ManyToOne
	private Produto produtoOrigem;
	
	@ManyToMany
	private List<Produto> produtoSimilares;
		
	@NotNull
	@ManyToOne
	private User user;
	
	public Long getId() {
		return id;
	}

	public Produto getProdutoOrigem() {
		return produtoOrigem;
	}

	public List<Produto> getProdutosSimilares() {
		return produtoSimilares;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProdutoOrigem(Produto produtoOrigem) {
		this.produtoOrigem = produtoOrigem;
	}

	public void setProdutosSimilares(List<Produto> produtosSimilares) {
		this.produtoSimilares = produtosSimilares;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
