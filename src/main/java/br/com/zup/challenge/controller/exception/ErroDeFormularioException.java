package br.com.zup.challenge.controller.exception;

import br.com.zup.challenge.config.validacao.ErroDeFormulario;

public class ErroDeFormularioException extends Exception{
	

	/**
	 * 
	 */
	
	private ErroDeFormulario erroDeFormulario;
	
	private static final long serialVersionUID = 1L;

	public ErroDeFormularioException(ErroDeFormulario erroDeFormulario) {
		this.erroDeFormulario = erroDeFormulario;
	}

	public ErroDeFormulario getErroDeFormulario() {
		return erroDeFormulario;
	}
}
