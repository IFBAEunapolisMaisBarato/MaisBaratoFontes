package br.edu.ifba.eunapolis.model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
 
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotNull    
    @Size(min = 10, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Não Pode Conter Numeros")
	private String nome;
	
	@NotNull
	private String email;
	
	@ManyToMany
	private List<ListaCompra> listaCompras;
	
	@ManyToMany
	private List<Produto> favoritos;
	
	@OneToOne
	private Similar similar;
	
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

	public Similar getSimilar() {
		return similar;
	}

	public void setSimilar(Similar similar) {
		this.similar = similar;
	}
	

}
