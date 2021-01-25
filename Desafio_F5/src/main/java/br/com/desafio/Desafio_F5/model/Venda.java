package br.com.desafio.Desafio_F5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class Venda {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenda;
	@OneToOne @NotNull 
	private Produto produto;
	@OneToOne @NotNull
	private Cliente cliente;
	private int quantidade;
	
	public Venda() {
		super();
	}
	
	public Venda(Produto p, Cliente c, int quantidade) {
		this.produto = p;
		this.cliente = c;
		this.quantidade = quantidade;
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idVenda ^ (idVenda >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (idVenda != other.idVenda)
			return false;
		return true;
	}
}
