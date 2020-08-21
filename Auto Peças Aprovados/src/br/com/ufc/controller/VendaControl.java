package br.com.ufc.controller;

import java.text.BreakIterator;
import java.util.Scanner;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;
import Visual.Application;

public class VendaControl {

	private ConnectionPSQL connectionPSQL;
	private VendaDAO vendaDao;
	private Scanner scan = new Scanner(System.in);
	
	public VendaControl() {
		this.connectionPSQL = new ConnectionPSQL();
		this.vendaDao = new VendaDAO(connectionPSQL);
		this.scan = new Scanner(System.in);
	}
	
	public void RealizarVenda() {
		Venda venda = new Venda();
		Application ap = new Application();		
		
		System.out.println("------------Cadastro Cliente------------");
		System.out.println(" ");
		System.out.println("Código da Venda: ");
		venda.setCod_venda(scan.nextInt());
		System.out.println("Código do Funcionario: ");
		venda.setCod_funcionario(scan.nextInt());
		System.out.println("Código do produto: ");
		venda.setCod_produto(scan.nextInt());
		System.out.println("Quantidade: ");
		venda.setQuantidade(scan.nextInt());
		
		if(vendaDao.inserir(venda) == true) {
			System.out.println("Venda realizada com sucesso.");
			ap.LimparTela();
			ap.MenuVenda();
		}else {
			System.out.println("Venda não realizada.");
			ap.LimparTela();
			ap.MenuVenda();
		}
	}
	
	public Venda BuscarVenda() {
		Venda venda;
		int codigo;
		Application ap = new Application();	
		
		System.out.println("------------Buscar Venda------------");
		System.out.println(" ");
		System.out.println("Código: ");
		
		codigo = scan.nextInt();
		venda = vendaDao.buscar(codigo);
		
		if(venda.getCod_venda() != 0) {
			System.out.println(venda.toString());
			ap.LimparTela();
			ap.MenuVenda();
			return venda;
		}else {
			System.out.println("Venda não encontrado.");
			ap.LimparTela();
			ap.MenuVenda();
		}
		return null;
	}
	
}
