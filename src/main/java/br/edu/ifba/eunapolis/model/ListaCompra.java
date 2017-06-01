package br.edu.ifba.eunapolis.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
@NamedQueries({
		@NamedQuery(name = "ListaCompra.consultarPorUsuario", query = "SELECT lista FROM ListaCompra lista WHERE lista.user.fbID =:fbId"),
		
})
@Entity
public class ListaCompra extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -2916653125263688518L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Produto> produtos;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Orcamento> orcamentos;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	private boolean status;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
