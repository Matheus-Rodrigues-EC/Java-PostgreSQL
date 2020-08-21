package br.com.ufc.model;

public class Estoque {

	private int codigo_fornecedor;
	private int codigo_produto;
	private int quantidade;
	
	public Estoque() {
		
	}

	@Override
	public String toString() {
		return "Código do fornecedor: " + codigo_fornecedor + " | Código do  produto: " + codigo_produto
				+ " | Quantidade: " + quantidade;
	}

	public int getCodigo_fornecedor() {
		return codigo_fornecedor;
	}

	public void setCodigo_fornecedor(int codigo_fornecedor) {
		this.codigo_fornecedor = codigo_fornecedor;
	}

	public int getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(int codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
}
