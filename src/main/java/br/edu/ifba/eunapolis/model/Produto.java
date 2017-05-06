package br.edu.ifba.eunapolis.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;
import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
 
@Entity
public class Produto extends AbstractEntity{

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@ManyToOne
	private Marca marca;

	private Blob foto;

	@NotNull
	@NotBlank
	private String codigoBarra;

	@NotNull
	@ManyToOne
	private CategoriaProduto categoriaProduto;

	@NotNull
	@ManyToOne
	private UnidadeMedida unidadeMedida;
	
	@NotNull
	@ManyToOne
	private User user;

	@NotNull
	@DecimalMax("99999.999999")
	private Double qtdMedida;
	

	@NotNull
	@DefaultValue(value = "false")
	private boolean ativo;

	private int pontuacao;
	

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

	public boolean isAtivo() {
		return ativo;
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

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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

}
