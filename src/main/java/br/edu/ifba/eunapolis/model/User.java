package br.edu.ifba.eunapolis.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
@NamedQueries({ 
	@NamedQuery(name = "User.consultaPorEmail", 
			query = "SELECT u FROM User u WHERE u.email = :email"),
	@NamedQuery(name = "User.consultaPorFbId", 
			query = "SELECT u FROM User u WHERE u.fbID = :fbId"),
	@NamedQuery(name = "User.consultarIdPorEmail", 
			query = "SELECT u.id FROM User u WHERE u.email = :email") })
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	private String fbID;
	
	@NotNull    
    @Size(min = 10, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Não Pode Conter Numeros")
	private String nome;
	
	@NotNull
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private List<ListaCompra> listaCompras;
	
	@ManyToMany
	private List<Produto> favoritos;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Similar> similar;
	
	private int pontuacao;
	
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

	public List<Similar> getSimilar() {
		return similar;
	}
	public void setSimilar(List<Similar> similar) {
		this.similar = similar;
	}
	public String getFbID() {
		return fbID;
	}
	public void setFbID(String fbID) {
		this.fbID = fbID;
	}
	

}
