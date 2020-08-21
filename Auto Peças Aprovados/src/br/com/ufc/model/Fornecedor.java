package br.com.ufc.model;

public class Fornecedor {

	private int	codigo_fornecedor;
	private String	cnpj;
	private String	nome;
	private String	telefone;
	
	public Fornecedor() {
		
	}
	
	

	@Override
	public String toString() {
		return "Código do fornecedor: " + codigo_fornecedor + " | CNPJ: " + cnpj + " | Nome: " + nome
				+ " | Telefone: " + telefone;
	}



	public int getCodigo_fornecedor() {
		return codigo_fornecedor;
	}

	public void setCodigo_fornecedor(int codigo_fornecedor) {
		this.codigo_fornecedor = codigo_fornecedor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
