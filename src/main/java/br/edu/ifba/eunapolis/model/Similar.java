package br.edu.ifba.eunapolis.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	@PreUpdate
	public void setLastUpdate() {
		this.updated_at = new Date();
	}

	@PrePersist
	public void setCreated() {
		this.created_at = new Date();
	}

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

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}
}
