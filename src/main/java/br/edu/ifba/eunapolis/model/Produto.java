package br.edu.ifba.eunapolis.model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */

@Entity
public class Produto extends AbstractEntity {

	@Override
	public String toString() {
		return nome +" "+ marca.getNome() +" "+ qtdMedida +" "+ unidadeMedida.getSigla();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message="Preencha o Campo")
	@Size(min = 2, max = 30)
	private String nome;

	@NotNull(message="Escolha uma Marca")
	@ManyToOne
	private Marca marca;

	private Blob foto;

	@ManyToMany(cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SELECT)
	private List<Similar> similares;

	@ManyToMany(cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SELECT)
	private List<ListaCompra> listaCompra;

	@NotNull (message="Preencha o Campo")
	private String codigoBarra;

	@NotNull (message="Preencha o Campo")
	@ManyToOne
	private CategoriaProduto categoriaProduto;

	@NotNull(message="Escolha uma Unidade de Medida")
	@ManyToOne
	private UnidadeMedida unidadeMedida;

	public List<ListaCompra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(List<ListaCompra> listaCompra) {
		this.listaCompra = listaCompra;
	}

	@NotNull
	@ManyToOne
	private User user;

	@NotNull
	@DecimalMax("99999.999999")
	private Double qtdMedida;

	private Boolean valido;

	private int pontuacao;

	@PrePersist
	private void setValido() {
		this.setValido(true);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Marca getMarca() {
		return marca;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public Double getQtdMedida() {
		return qtdMedida;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public Blob getFoto() {
		return foto;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public void setQtdMedida(Double qtdMedida) {
		this.qtdMedida = qtdMedida;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getValido() {
		return valido;
	}

	public void setValido(Boolean valido) {
		this.valido = valido;
	}

	public List<Similar> getSimilares() {
		return similares;
	}

	public void setSimilares(List<Similar> similares) {
		this.similares = similares;
	}

}
