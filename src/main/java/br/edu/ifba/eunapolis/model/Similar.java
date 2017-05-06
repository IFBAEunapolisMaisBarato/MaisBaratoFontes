package br.edu.ifba.eunapolis.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Similar extends AbstractEntity {

	@Id
    @GeneratedValue
    private Long id;
	
	@NotNull
	@NotBlank
	@ManyToMany
	private List<Produto> produtoOrigem;
	
	@ManyToMany
	private List<Produto> produtosSimilares;
		
	@NotNull
	@NotEmpty
	@OneToOne
	private User user;

	public Long getId() {
		return id;
	}

	public List<Produto> getProdutoOrigem() {
		return produtoOrigem;
	}

	public List<Produto> getProdutosSimilares() {
		return produtosSimilares;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProdutoOrigem(List<Produto> produtoOrigem) {
		this.produtoOrigem = produtoOrigem;
	}

	public void setProdutosSimilares(List<Produto> produtosSimilares) {
		this.produtosSimilares = produtosSimilares;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
