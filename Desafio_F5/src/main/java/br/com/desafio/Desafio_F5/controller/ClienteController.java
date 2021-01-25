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

import br.com.desafio.Desafio_F5.dao.ClienteDAOIfc;
import br.com.desafio.Desafio_F5.model.Cliente;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteDAOIfc cliente;
	
	@GetMapping
	@ResponseBody
	public List<Cliente> listarClientes(String cpf){
		if(cpf == null) {
			List<Cliente> cli = this.cliente.findAll();
			return cli;
		}else {
			return Arrays.asList(this.cliente.findByCpf(cpf));
		}
	}
	
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cli, UriComponentsBuilder uriBuilder) {
		Cliente c = new Cliente(cli.getNome(),cli.getTelefone(),cli.getCpf());
		 c = cliente.save(c);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(c).toUri();
		return ResponseEntity.created(uri).body(c);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable int id){
		cliente.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
