package br.com.zup.challenge.controller.form;

import javax.validation.constraints.NotEmpty;

public class EnderecoForm {

	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String CEP;
	
	@NotEmpty
	private String rua;
	
	@NotEmpty
	private String logradouro;
	
	@NotEmpty
	private String cidade;

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
}
