package br.com.zup.challenge.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.challenge.controller.exception.ErroDeFormularioException;
import br.com.zup.challenge.controller.form.ClienteForm;
import br.com.zup.challenge.model.Cliente;
import br.com.zup.challenge.service.ClienteService;

/**
 * 
 * @author Emanuel S. Oliveira
 *
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> detalhesCliente(@PathVariable Long id){
		Optional<Cliente> usuario = clienteService.buscaCliente(id);
		
		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}
		
		return ResponseEntity.notFound().build(); 
	}
	
	@GetMapping
	public Page<Cliente> listaClientes(@PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		return clienteService.listaClientes(paginacao);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) throws ErroDeFormularioException{
		Cliente cliente = clienteForm.converter();
		cliente = clienteService.salvaCliente(cliente);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) throws ErroDeFormularioException{
		Optional<Cliente> cliente = clienteService.buscaCliente(id);
		if(cliente.isPresent()) {
			Cliente clienteAtualizado = clienteForm.converter(cliente.get());
			clienteAtualizado = clienteService.salvaCliente(clienteAtualizado);
			return ResponseEntity.ok(cliente);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Cliente> cliente = clienteService.buscaCliente(id);
		if(cliente.isPresent()) {
			clienteService.deletarCliente(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
