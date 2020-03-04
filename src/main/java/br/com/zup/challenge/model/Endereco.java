package br.com.zup.challenge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import br.com.zup.challenge.controller.form.EnderecoForm;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	private String CEP;
	
	private String rua;
	
	private String logradouro;
	
	private String cidade;

	public Endereco(EnderecoForm enderecoForm) {
		BeanUtils.copyProperties(enderecoForm, this);
	}
	
	public Endereco() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", nome=" + nome + ", CEP=" + CEP + ", rua=" + rua + ", logradouro=" + logradouro
				+ ", cidade=" + cidade + "]";
	}
}
