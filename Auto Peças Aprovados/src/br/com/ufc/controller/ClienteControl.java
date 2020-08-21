package br.com.ufc.controller;

import java.text.BreakIterator;
import java.util.Scanner;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;
import Visual.Application;

public class ClienteControl {
	
	private ConnectionPSQL connectionPSQL;
	private ClienteDAO clienteDao;
	private Scanner scan = new Scanner(System.in);
	
	public ClienteControl() {
		this.connectionPSQL = new ConnectionPSQL();
		this.clienteDao = new ClienteDAO(connectionPSQL);
		this.scan = new Scanner(System.in);
	}
		
	public void CadastrarCliente() {
		Cliente cliente = new Cliente();
		Application ap = new Application();		
		
		System.out.println("------------Cadastro Cliente------------");
		System.out.println(" ");
		System.out.println("Nome: ");
		cliente.setNome(scan.nextLine());
		System.out.println("CPF: ");
		cliente.setCpf(scan.nextLine());
		System.out.println("Endereço: ");
		cliente.setEndereco(scan.nextLine());
		System.out.println("Telefone: ");
		cliente.setTelefone(scan.nextLine());
		
		
		if(clienteDao.inserir(cliente) == true) {
			System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso.");
			ap.LimparTela();
			ap.MenuCliente();
		}else {
			System.out.println("Cliente não cadastrado.");
			ap.LimparTela();
			ap.MenuCliente();
		}
	}
	
	public Cliente BuscarCliente() {
		Cliente cliente;
		String cpf = "";
		Application ap = new Application();	
		
		System.out.println("------------Buscar Cliente------------");
		System.out.println(" ");
		System.out.println("CPF: ");
		
		cpf = scan.nextLine();
		cliente = clienteDao.buscar(cpf);
		
		if(cliente.getCpf() != null) {
			System.out.println(cliente.toString());
			ap.LimparTela();
			ap.MenuCliente();
			return cliente;
		}else {
			System.out.println("Cliente não encontrado.");
			ap.LimparTela();
			ap.MenuCliente();
		}
		return null;
	}
	
	public void RemoverCliente() {
		Cliente cliente = new Cliente();
		//Scanner scan =  new Scanner(System.in);
		String cpf;
		Application ap = new Application();	
		
		System.out.println("------------Remover Cliente------------");
		System.out.println(" ");
		System.out.println("CPF: ");
		
		cpf = scan.nextLine();
		cliente.setCpf(cpf);
		
		if(cliente.getCpf()!= null) {
			clienteDao.remover(cliente);
			System.out.println("Cliente removido com sucesso.");
			ap.LimparTela();
			ap.MenuCliente();
		}else {
			System.out.println("Cliente não removido.");
			ap.LimparTela();
			ap.MenuCliente();
		}
		
	}
	
}
