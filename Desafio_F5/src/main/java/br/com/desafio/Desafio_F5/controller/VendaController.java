package br.com.desafio.Desafio_F5.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.Desafio_F5.controller.dto.VendaDTO;
import br.com.desafio.Desafio_F5.dao.ClienteDAOIfc;
import br.com.desafio.Desafio_F5.dao.ProdutoDAOIfc;
import br.com.desafio.Desafio_F5.dao.VendaDAOIfc;
import br.com.desafio.Desafio_F5.model.Cliente;
import br.com.desafio.Desafio_F5.model.Produto;
import br.com.desafio.Desafio_F5.model.Venda;

@Controller
@RequestMapping(value="/venda")
public class VendaController {

	@Autowired
	private VendaDAOIfc venda;
	@Autowired
	private ProdutoDAOIfc produto;
	@Autowired
	private ClienteDAOIfc cliente;
	
	@GetMapping
	@ResponseBody
	public List<Venda> listarVendas(String cpf){
		if(cpf == null) {
			List<Venda> v = this.venda.findAll();
			return v;
		}else {
			return Arrays.asList(this.venda.findByClienteCpf(cpf));
		}
	}
	
	
	@PostMapping
	public ResponseEntity<Venda> cadastrar(@RequestBody VendaDTO ven, UriComponentsBuilder uriBuilder) {
		System.out.println(ven.toString()); 
		Produto p = produto.findByNome(ven.getNomeProduto());
		Cliente c = cliente.findByCpf(ven.getCpf());
		if(c == null || p == null || p.getQuantidade() < ven.getQuantidade() || p.getQuantidade() == 0 ) {
			return ResponseEntity.notFound().build();
		}
		Venda v = new Venda(p,c,ven.getQuantidade());
		p.setQuantidade(p.getQuantidade() - v.getQuantidade());
		v = venda.save(v);
		URI uri = uriBuilder.path("/venda/{id}").buildAndExpand(v.getIdVenda()).toUri();
		return ResponseEntity.created(uri).body(v);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable int id){
		venda.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
