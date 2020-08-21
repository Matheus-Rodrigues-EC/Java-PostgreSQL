package br.com.ufc.model;

public class Produto {

	private int	codigo_produto;
	private String	nome;
	private int		codigo_fornecedor;
	private float	preco;
	
	public Produto() {
		
	}
	
	

	@Override
	public String toString() {
		return "Código do produto: " + codigo_produto + " | Nome: " + nome + " | Código do fornecedor: "
				+ codigo_fornecedor + " | Preço: " + preco;
	}



	public int getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(int codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo_fornecedor() {
		return codigo_fornecedor;
	}

	public void setCodigo_fornecedor(int codigo_fornecedor) {
		this.codigo_fornecedor = codigo_fornecedor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}


}
