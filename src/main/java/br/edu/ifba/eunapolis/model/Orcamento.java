package br.edu.ifba.eunapolis.model;

import java.util.List;


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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
@NamedQueries({
	@NamedQuery(name = "Orcamento.consultarPorLista", query = "SELECT o FROM Orcamento o join fetch o.precoProduto WHERE o.listaCompra.id =:listaId ")		
})
@Entity
public class Orcamento extends AbstractEntity {

	public ListaCompra getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ListaCompra listaCompra) {
		this.listaCompra = listaCompra;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	private String nome;
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
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
