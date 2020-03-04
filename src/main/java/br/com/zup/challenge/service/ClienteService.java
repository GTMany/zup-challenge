package br.com.zup.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zup.challenge.config.validacao.ErroDeFormulario;
import br.com.zup.challenge.controller.exception.ErroDeFormularioException;
import br.com.zup.challenge.model.Cliente;
import br.com.zup.challenge.repository.ClienteRepository;

/**
 * 
 * @author Emanuel S. Oliveira
 *
 */
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvaCliente(Cliente cliente) throws ErroDeFormularioException {
		List<Cliente> clientes = this.buscaClientePorCPF(cliente.getCPF());
		if(clientes.size() != 0) {
			throw new ErroDeFormularioException(new ErroDeFormulario("CPF", "Usuário já cadastrado"));
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Page<Cliente> listaClientes(Pageable paginacao){
		return clienteRepository.findAll(paginacao);
	}
	
	public List<Cliente> buscaClientePorCPF(String cpf){
		return clienteRepository.findByCPF(cpf);
	}

	public Optional<Cliente> buscaCliente(Long id) {
		return clienteRepository.findById(id);
	}

}
