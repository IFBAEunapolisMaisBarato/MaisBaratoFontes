package br.edu.ifba.eunapolis.model;

import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */

@Entity
public class Marca extends AbstractEntity {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotEmpty
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	private boolean valido;
	private int pontuacao;

	@PreUpdate
	public void setLastUpdate() {
		this.updated_at = new Date();
	}

	@PrePersist
	public void setCreated() {
		this.created_at = new Date();
	}

	public String getNome() {
		return nome;
	}

	public boolean isValido() {
		return valido;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

}
