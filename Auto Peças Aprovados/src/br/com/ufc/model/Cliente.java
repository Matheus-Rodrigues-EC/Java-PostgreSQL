package br.com.ufc.model;

public class Cliente {

	private String	nome;
	private String	cpf;
	private String	endereco;
	private String	telefone;
	
	public Cliente() {
		
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " | CPF: " + cpf + " | Endereço: " + endereco + " | Telefone: " + telefone + "\n";
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
