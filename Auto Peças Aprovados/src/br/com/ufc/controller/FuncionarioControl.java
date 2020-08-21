package br.com.ufc.controller;

import java.util.Scanner;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;
import Visual.Application;

public class FuncionarioControl {
	
	private ConnectionPSQL connectionPSQL;
	private FuncionarioDAO funcionarioDao;
	private Scanner scan = new Scanner(System.in);
	
	public FuncionarioControl() {
		this.connectionPSQL = new ConnectionPSQL();
		this.funcionarioDao = new FuncionarioDAO(connectionPSQL);
		this.scan = new Scanner(System.in);
	}
	
	public void CadastrarFuncionario() {
		Application ap = new Application();
		Funcionario funcionario = new Funcionario();
		
		System.out.println("---------Cadastrar Funcionario---------");
		System.out.println(" ");
		System.out.println("Nome: ");
		funcionario.setNome(scan.nextLine());
		System.out.println("CPF: ");
		funcionario.setCpf(scan.nextLine());
		System.out.println("Endereço: ");
		funcionario.setEndereco(scan.nextLine());
		System.out.println("Telefone: ");
		funcionario.setTelefone(scan.nextLine());
		System.out.println("Cargo: ");
		funcionario.setCargo(scan.nextLine());
		System.out.println("Salario: ");
		funcionario.setSalario(scan.nextFloat());
		
		if(funcionarioDao.inserir(funcionario) == true) {
			System.out.println("Funcionário " + funcionario.getNome() + " cadastrado com sucesso.\n");
			ap.LimparTela();
			ap.MenuFuncionario();
		}else {
			System.out.println("Funcionário não cadastrado.\n");
			ap.LimparTela();
			ap.MenuFuncionario();
		}
	}
	
	public Funcionario BuscarFuncionario() {
		Application ap = new Application();	
		Funcionario funcionario;
		int codigo1;
		
		System.out.println("---------Buscar Funcionario---------");
		System.out.println(" ");
		System.out.println("Código do Funcionario: ");
		
		codigo1 = scan.nextInt();
		funcionario = funcionarioDao.buscar(codigo1);
		
		if(funcionario != null) {
			System.out.println(funcionario.toString());
			ap.LimparTela();
			ap.MenuFuncionario();
			return funcionario;
		}else {
			System.out.println("Funcionario não encontrado.\n");
			ap.LimparTela();
			ap.MenuFuncionario();
		}
		return null;
	}
	
	public void RemoverFuncionario() {
		Application ap = new Application();
		Funcionario funcionario = new Funcionario();
		int codigo;
		
		System.out.println("---------Remover Funcionario---------");
		System.out.println(" ");
		System.out.println("Código do funcionario: ");
		
		codigo = scan.nextInt();
		funcionario.setCodigo_funcionario(codigo);
		
		if(funcionario.getCodigo_funcionario() != 0) {
			funcionarioDao.remover(funcionario);
			System.out.println("Funcionario removido com sucesso.");
			ap.LimparTela();
			ap.MenuFuncionario();
		}else {
			System.out.println("Funcionario não removido.");
			ap.LimparTela();
			ap.MenuFuncionario();
		}
	}

	public void AtualizarCargo() {
		Application ap = new Application();
		Funcionario funcionario = new Funcionario();
		int codigo;
		

		System.out.println("---------Atualizar Cargo---------");
		System.out.println(" ");
		System.out.println("Novo Cargo: ");
		funcionario.setCargo(scan.nextLine());
		System.out.println("Código do funcionario: ");
		
		codigo = scan.nextInt();
		funcionario.setCodigo_funcionario(codigo);
		
		if(funcionario.getCodigo_funcionario() != 0) {
			funcionarioDao.AtualizarCargo(funcionario);
			System.out.println("Cargo atualizado com sucesso.");
			ap.LimparTela();
			ap.MenuFuncionario();
		}else {
			System.out.println("Cargo não atualizado.");
			ap.LimparTela();
			ap.MenuFuncionario();
		}
	}
	
public void AtualizarSalario() {
	Application ap = new Application();
	Funcionario funcionario = new Funcionario();
	int codigo;
	
	System.out.println("---------Atualizar Salario---------");
	System.out.println(" ");
	System.out.println("Novo Salario: ");
	funcionario.setSalario(scan.nextFloat());
	System.out.println("Código do funcionario: ");
	
	codigo = scan.nextInt();
	funcionario.setCodigo_funcionario(codigo);
	
	if(funcionario.getCodigo_funcionario() != 0) {
		funcionarioDao.AtualizarSalario(funcionario);
		System.out.println("Salario atualizado com sucesso.");
		ap.LimparTela();
		ap.MenuFuncionario();
	}else {
		System.out.println("Salario não atualizado.");
		ap.LimparTela();
		ap.MenuFuncionario();
	}
	
	}
	
}
