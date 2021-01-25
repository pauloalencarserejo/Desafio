package br.com.desafio.Desafio_F5.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.Desafio_F5.model.Cliente;

public interface ClienteDAOIfc extends JpaRepository<Cliente, Integer>{
	
	 Cliente findByCpf(String cpf);

}
