package br.edu.ifba.eunapolis.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
 
@Entity
public class Orcamento extends AbstractEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	private String nome;
	
	@NotNull
	@ManyToMany
	private List<PrecoProduto> precoProduto;
	
	@ManyToMany
	private List<PontoVenda> pontoVendas;
	
	@ManyToOne
	@JoinColumn(name="listaCompra_id")
	private ListaCompra listaCompra;
	
	private boolean similar;

	public Long getId() {
		return Id;
	}

	public List<PrecoProduto> getPrecoProduto() {
		return precoProduto;
	}

	public List<PontoVenda> getPontoVendas() {
		return pontoVendas;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setPrecoProduto(List<PrecoProduto> precoProduto) {
		this.precoProduto = precoProduto;
	}

	public void setPontoVendas(List<PontoVenda> pontoVendas) {
		this.pontoVendas = pontoVendas;
	}

	public boolean isSimilar() {
		return similar;
	}

	public void setSimilar(boolean similar) {
		this.similar = similar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
