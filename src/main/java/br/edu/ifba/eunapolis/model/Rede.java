package br.edu.ifba.eunapolis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
 
@Entity
public class Rede {

	@Id
    @GeneratedValue
    private Long id;
	
	@NotNull
    @NotEmpty
	private String nome;
	
	private boolean valido;
	private int pontuacao;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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


}
