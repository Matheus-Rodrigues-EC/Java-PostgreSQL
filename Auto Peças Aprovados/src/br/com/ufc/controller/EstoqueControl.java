package br.com.ufc.controller;

import java.text.BreakIterator;
import java.util.Scanner;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;
import Visual.Application;

public class EstoqueControl {
	
	private ConnectionPSQL connectionPSQL;
	private EstoqueDAO estoqueDao;
	private Scanner scan = new Scanner(System.in);
	
	public EstoqueControl() {
		this.connectionPSQL = new ConnectionPSQL();
		this.estoqueDao = new EstoqueDAO(connectionPSQL);
		this.scan = new Scanner(System.in);
	}
	
	public void AdicionarItem() {
		Estoque item = new Estoque();
		Application ap = new Application();		
		
		System.out.println("------------Adicionar no estoque------------");
		System.out.println(" ");
		System.out.println("Código do fornecedor: ");
		item.setCodigo_fornecedor(scan.nextInt());
		System.out.println("Código do produto: ");
		item.setCodigo_produto(scan.nextInt());
		System.out.println("Quantidade: ");
		item.setQuantidade(scan.nextInt());		
		
		if(estoqueDao.Inserir(item) == true) {
			System.out.println("Item adicionado com sucesso.");
			ap.LimparTela();
			ap.MenuEstoque();
		}else {
			System.out.println("Item não adicionado.");
			ap.LimparTela();
			ap.MenuEstoque();
		}
	}
	
	public Estoque BuscarItem() {
		Application ap = new Application();
		Estoque item;
		int codigo;
		
		System.out.println("---------Buscar Item---------");
		System.out.println(" ");
		System.out.println("Código do produto: ");
		
		codigo = scan.nextInt();
		item = estoqueDao.buscar(codigo);
		
		if(item.getCodigo_produto() != 0) {
			System.out.println(item.toString());
			ap.LimparTela();
			ap.MenuEstoque();
			return item;
		}else {
			System.out.println("Item não encontrado.");
			ap.LimparTela();
			ap.MenuEstoque();
		}
		return null;
	}
	
	public void RemoverItem() {
		Estoque item = new Estoque();
		int codigo;
		Application ap = new Application();
		
		System.out.println("----------Remover Item---------");
		System.out.println(" ");
		System.out.println("Código do produto: ");
		
		codigo = scan.nextInt();
		item.setCodigo_produto(codigo);
		
		if(item.getCodigo_produto() != 0) {
			estoqueDao.Remover(item);
			System.out.println("Item removido com sucesso.");
			ap.LimparTela();
			ap.MenuEstoque();
		}else {
			System.out.println("Item não removido.");
			ap.LimparTela();
			ap.MenuEstoque();
		}
		
	}
	
}