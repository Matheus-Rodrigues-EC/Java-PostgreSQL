package br.com.ufc.model;

public class Venda {

	private int cod_venda;
	private int cod_funcionario;
	private int cod_produto;
	private int quantidade;
	
	public Venda() {
		
	}

	@Override
	public String toString() {
		return "Código de Venda: " + cod_venda + " | Código do Funcionario: " + cod_funcionario + " | Código do Produto: " + cod_produto
				+ " | Quantidade: " + quantidade;
	}

	public int getCod_venda() {
		return cod_venda;
	}

	public void setCod_venda(int cod_venda) {
		this.cod_venda = cod_venda;
	}

	public int getCod_funcionario() {
		return cod_funcionario;
	}

	public void setCod_funcionario(int cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}

	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
}
