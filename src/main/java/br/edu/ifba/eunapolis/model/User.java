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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
 
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends AbstractEntity {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@NotNull
    @NotEmpty
    @Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String nome;
	
	@NotNull
    @NotEmpty
	private String email;
	
	@ManyToMany
	private List<ListaCompra> listaCompras;
	
	@ManyToMany
	private List<Produto> favoritos;
	
	@OneToOne
	private Similar similar;
	
	private int pontuacao;
	
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
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public List<ListaCompra> getListaCompras() {
		return listaCompras;
	}
    
	public int getPontuacao() {
		return pontuacao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setListaCompras(List<ListaCompra> listaCompras) {
		this.listaCompras = listaCompras;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<Produto> getFavoritos() {
		return favoritos;
	}
	public void setFavoritos(List<Produto> favoritos) {
		this.favoritos = favoritos;
	}

	public Similar getSimilar() {
		return similar;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setSimilar(Similar similar) {
		this.similar = similar;
	}
	

}
