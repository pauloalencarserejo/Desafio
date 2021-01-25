package br.com.desafio.Desafio_F5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.desafio.Desafio_F5.model.Cliente;
import br.com.desafio.Desafio_F5.model.Venda;

public interface VendaDAOIfc extends JpaRepository<Venda, Integer> {

	Venda findByClienteCpf(String cpf);
}
