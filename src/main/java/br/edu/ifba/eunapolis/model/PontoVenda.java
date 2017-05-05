package br.edu.ifba.eunapolis.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Vitor
 * @version 1.0.0
 * @since 29/04/2017
 *
 */
 
@Entity
public class PontoVenda {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@NotBlank
	private String descricao;
	
	@ManyToOne
	private Rede rede;

	@NotNull
	private int latitude;

	@NotNull
	private int longitude;

	@NotNull
	@DefaultValue(value ="false")
	private boolean ativo;

	private int pontuacao;

	private Blob foto;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Rede getRede() {
		return rede;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getLongitude() {
		return longitude;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRede(Rede rede) {
		this.rede = rede;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
