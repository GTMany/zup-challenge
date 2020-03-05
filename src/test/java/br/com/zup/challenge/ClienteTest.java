package br.com.zup.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zup.challenge.controller.exception.ErroDeFormularioException;
import br.com.zup.challenge.model.Cliente;
import br.com.zup.challenge.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZupChallengeApplication.class)
public class ClienteTest {
	
	private Logger logger = LoggerFactory.getLogger(ClienteTest.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
    private ObjectMapper mapper;

	@Test
	public void aoCadastrarDoisUsuariosComOMesmoCPFCadastraSomenteUm() throws JsonProcessingException {
		//Seta o CPF
		String cpf = "28450714001";
		
		//Seta o cliente 1
		Cliente clienteEmanuel = new Cliente();
		clienteEmanuel.setCPF(cpf);
		clienteEmanuel.setDataNascimento(LocalDate.now().minusYears(20));
		clienteEmanuel.setNome("Emanuel S. Oliveira");
		
		//Seta o cliente 2
		Cliente clienteJoao = new Cliente();
		clienteJoao.setCPF(cpf);
		clienteJoao.setDataNascimento(LocalDate.now().minusYears(25));
		clienteJoao.setNome("João Pereira da silva");
		
		try {
			clienteService.salvaCliente(clienteEmanuel);
			clienteService.salvaCliente(clienteJoao);
		} catch (ErroDeFormularioException ex) {
			logger.error(mapper.writeValueAsString(ex.getErroDeFormulario()));
		}
		
		assertEquals(1, clienteService.buscaClientePorCPF(cpf).size());
	}

}
