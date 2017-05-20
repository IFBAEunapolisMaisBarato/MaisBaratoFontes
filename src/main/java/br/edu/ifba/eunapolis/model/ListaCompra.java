package br.edu.ifba.eunapolis.model;

import javax.validation.constraints.NotNull;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
@NamedQueries({
	  @NamedQuery(name = "ListaCompra.consultarTodos",
	              query= "SELECT lista FROM ListaCompra lista order by lista.nome asc"),

	  @NamedQuery(name = "ListaCompra.consultarPorUsuario",
	              query = " SELECT lista  FROM ListaCompra lista  WHERE lista.id = :id "),
	})
@Entity
public class ListaCompra extends AbstractEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String nome;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Produto> produtos;
	
	@ManyToMany
	private List<Orcamento> orcamentos;
	
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


}
