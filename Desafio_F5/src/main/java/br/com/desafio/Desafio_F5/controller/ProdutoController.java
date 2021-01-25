package br.com.desafio.Desafio_F5.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.Desafio_F5.dao.ProdutoDAOIfc;
import br.com.desafio.Desafio_F5.model.Produto;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDAOIfc produto;
	
	@GetMapping
	@ResponseBody
	public List<Produto> listarProdutos(String nome){
		if(nome == null) {
			List<Produto> p = this.produto.findAll();
			return p;
		}else {
			return Arrays.asList(this.produto.findByNome(nome));
		}
	}

	
	@PostMapping
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto p, UriComponentsBuilder uriBuilder) {
		Produto pro = new Produto(p.getNome(),p.getPreço(),p.getQuantidade());
		pro = produto.save(pro);
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(pro.getIdproduto()).toUri();
		return ResponseEntity.created(uri).body(pro);
	} 
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable int id){
		produto.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
