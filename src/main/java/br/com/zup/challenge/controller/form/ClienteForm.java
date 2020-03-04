package br.com.zup.challenge.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;

import br.com.zup.challenge.model.Cliente;
import br.com.zup.challenge.model.Endereco;

public class ClienteForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	
	@CPF
	private String CPF;
	
	@Past
	private LocalDate dataNascimento;
	
	@NotNull
	private EnderecoForm endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public EnderecoForm getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoForm endereco) {
		this.endereco = endereco;
	}
	public Cliente converter() {
		Cliente cliente = new Cliente(this);
		cliente.setEndereco(new Endereco(this.getEndereco()));
		return cliente;
	}
	
	public Cliente converter(Cliente cliente) {
		BeanUtils.copyProperties(this, cliente);
		BeanUtils.copyProperties(endereco, cliente.getEndereco());
		return cliente;
	}
	
}
