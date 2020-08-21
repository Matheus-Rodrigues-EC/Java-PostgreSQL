package br.com.ufc.model;

public class Funcionario {

	private String	nome;
	private String	cpf;
	private String	endereco;
	private String	telefone;
	private int		codigo_funcionario;
	private String	cargo;
	private float	salario;
	
	public Funcionario () {
		
	}

	
	
	@Override
	public String toString() {
		return "Nome: " + nome + " | CPF: " + cpf + " | Endereço: " + endereco + " | Telefone: " + telefone
				+ " | Código do funcionario: " + codigo_funcionario + " | Cargo: " + cargo + " | Salario: " + salario;
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

	public void setEndereco(String edereco) {
		this.endereco = edereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCodigo_funcionario() {
		return codigo_funcionario;
	}

	public void setCodigo_funcionario(int codigo_funcionario) {
		this.codigo_funcionario = codigo_funcionario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	
	
	
}
