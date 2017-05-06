package br.edu.ifba.eunapolis.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@GeneratedValue
	private Long Id;
	
	@NotNull
	@ManyToMany
	private List<PrecoProduto> precoProduto;
	
	@NotNull
	@ManyToMany
	private List<PontoVenda> pontoVendas;
	
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
	
}
