package br.com.zup.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.challenge.model.Cliente;

/**
 * 
 * @author Emanuel S. Oliveira
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByCPF(String cpf);

}
