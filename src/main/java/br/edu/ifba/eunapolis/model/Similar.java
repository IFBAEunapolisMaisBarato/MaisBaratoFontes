package br.edu.ifba.eunapolis.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@NamedQueries({	  
	  @NamedQuery(name = "Similar.consultarTodosPorUsuario",
	              query = "SELECT s FROM Similar s WHERE s.user.email =:email")
	})
@Entity
public class Similar extends AbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@ManyToOne
	private Produto produtoOrigem;
	
	@NotNull
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Produto> produtosSimilares;
		
	@NotNull
	@ManyToOne
	private User user;
	
	public Long getId() {
		return id;
	}

	public Produto getProdutoOrigem() {
		return produtoOrigem;
	}

	public List<Produto> getProdutosSimilares() {
		return produtosSimilares;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProdutoOrigem(Produto produtoOrigem) {
		this.produtoOrigem = produtoOrigem;
	}

	public void setProdutosSimilares(List<Produto> produtosSimilares) {
		this.produtosSimilares = produtosSimilares;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
