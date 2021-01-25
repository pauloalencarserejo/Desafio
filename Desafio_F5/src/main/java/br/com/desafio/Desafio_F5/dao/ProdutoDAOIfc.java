package br.com.desafio.Desafio_F5.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.Desafio_F5.model.Produto;

public interface ProdutoDAOIfc extends JpaRepository<Produto, Integer> {

	Produto findByNome(String nome);
}
