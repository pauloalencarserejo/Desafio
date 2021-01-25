package br.com.desafio.Desafio_F5.controller.dto;

public class VendaDTO {

	private String NomeProduto;
	private String cpf;
	private int quantidade;
	
	public String getNomeProduto() {
		return NomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		NomeProduto = nomeProduto;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "VendaDTO [NomeProduto=" + NomeProduto + ", cpf=" + cpf + ", quantidade=" + quantidade + "]";
	}
	
	
	
}
