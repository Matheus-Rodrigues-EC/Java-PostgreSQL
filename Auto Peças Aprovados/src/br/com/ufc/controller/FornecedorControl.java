package br.com.ufc.controller;

import java.util.Scanner;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;
import Visual.Application;

public class FornecedorControl {
	
	private ConnectionPSQL connectionPSQL;
	private FornecedorDAO fornecedorDao;
	private Scanner scan;
	
	public FornecedorControl() {
		this.connectionPSQL = new ConnectionPSQL();
		this.fornecedorDao = new FornecedorDAO(connectionPSQL);
		this.scan = new Scanner(System.in);
	}
	
	public void CadastrarFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		Application ap = new Application();	
		
		System.out.println("---------Cadastrar Fornecedor---------");
		System.out.println(" ");
		System.out.println("Codigo do Fornecedor: ");
		fornecedor.setCodigo_fornecedor(scan.nextInt());
		System.out.println("CNPJ: ");
		fornecedor.setCnpj(scan.nextLine());
		System.out.println(" ");
		fornecedor.setCnpj(scan.nextLine());
		System.out.println("Nome: ");
		fornecedor.setNome(scan.nextLine());
		System.out.println("Telefone: ");
		fornecedor.setTelefone(scan.nextLine());
		
		if(fornecedorDao.inserir(fornecedor) == true) {
			System.out.println("Fornecedor " + fornecedor.getNome() + " cadastrado com sucesso.\n");
			ap.LimparTela();
			ap.MenuFornecedor();
		}else {
			System.out.println("Fronecedor não cadastrado.\n");
			ap.LimparTela();
			ap.MenuFornecedor();
		}
	}
	
	public Fornecedor BuscarFornecedor() {
		Application ap = new Application();	
		Fornecedor fornecedor;
		int codigo1;
		
		System.out.println("---------Buscar Fornecedor---------");
		System.out.println(" ");
		System.out.println("Código do Fornecedor: ");
		
		codigo1 = scan.nextInt();
		fornecedor = fornecedorDao.buscar(codigo1);
		
		if(fornecedor != null) {
			System.out.println(fornecedor.toString());
			ap.LimparTela();
			ap.MenuFornecedor();
			return fornecedor;
		}else {
			System.out.println("Fornecedor não encontrado.\n");
			ap.LimparTela();
			ap.MenuFornecedor();
		}
		return null;
	}
	
	public void RemoverFornecedor() {
		Application ap = new Application();	
		Fornecedor fornecedor = new Fornecedor();
		int codigo;
		
		System.out.println("---------Remover Fornecedor---------");
		System.out.println(" ");
		System.out.println("Código do Fornecedor: ");
		codigo = scan.nextInt();
		fornecedor.setCodigo_fornecedor(codigo);
		
		if(fornecedor.getCodigo_fornecedor() != 0) {
			fornecedorDao.remover(fornecedor);
			System.out.println("Fornecedor removido com sucesso.\n");
			ap.LimparTela();
			ap.MenuFornecedor();
		}else {
			System.out.println("Fornecedor não removido.\n");
			ap.LimparTela();
			ap.MenuFornecedor();
		}
	}

}
