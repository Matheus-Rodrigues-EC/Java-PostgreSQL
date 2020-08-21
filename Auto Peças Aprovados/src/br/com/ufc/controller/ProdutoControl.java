package br.com.ufc.controller;

import java.util.Scanner;

import br.com.ufc.connection.ConnectionPSQL;
import br.com.ufc.dao.*;
import br.com.ufc.model.*;
import Visual.Application;

public class ProdutoControl {
	
	private ConnectionPSQL connectionPSQL;
	private ProdutoDAO produtoDao;
	private Scanner scan;

	public ProdutoControl() {
		this.connectionPSQL = new ConnectionPSQL();
		this.produtoDao = new ProdutoDAO(connectionPSQL);
		this.scan = new Scanner(System.in);
	}
	
	public void CadastrarProduto() {
		Application ap = new Application();
		Produto produto = new Produto();
		
		System.out.println("---------Cadastrar Produto---------");
		System.out.println(" ");
		System.out.println("Código do Produto: ");
		produto.setCodigo_produto(scan.nextInt());
		System.out.println(" ");
		produto.setNome(scan.nextLine());
		System.out.println("Nome: ");
		produto.setNome(scan.nextLine());
		System.out.println("Código do fornecedor: ");
		produto.setCodigo_fornecedor(scan.nextInt());
		System.out.println(" ");
		System.out.println("Preço: ");
		produto.setPreco(scan.nextFloat());
		
		if(produtoDao.inserir(produto) == true) {
			System.out.println("Produto " + produto.getNome() + " cadastrado com sucesso.");
			ap.LimparTela();
			ap.MenuProduto();
		}else {
			System.out.println("Produto não cadastrado.");
			ap.LimparTela();
			ap.MenuProduto();
		}
	}
	
	public void AtualizarPreco() {
		Application ap = new Application();
		Produto produto = new Produto();
		int codigo;
		
		System.out.println("---------Atualizar Nome---------");
		System.out.println(" ");
		System.out.println("Novo preço: ");
		produto.setPreco(scan.nextFloat());
		System.out.println("Código do Produto: ");
		produto.setCodigo_produto(scan.nextInt());
		
		codigo = scan.nextInt();
		produto.setCodigo_produto(codigo);
		
		if(codigo != 0) {
			produtoDao.AtualizarPreco(produto);
			System.out.println("Preço atualizado com sucesso.");
			ap.LimparTela();
			ap.MenuProduto();
		}else {
			System.out.println("Preço não atualizado.");
			ap.LimparTela();
			ap.MenuProduto();
		}
	}
	
	public Produto BuscarProduto() {
		Application ap = new Application();
		Produto produto;
		int codigo1;
		
		System.out.println("---------Buscar Produto---------");
		System.out.println(" ");
		System.out.println("Código do produto: ");
		
		codigo1 = scan.nextInt();
		produto = produtoDao.buscar(codigo1);
		
		if(produto.getCodigo_produto() != 0) {
			System.out.println(produto.toString());
			ap.LimparTela();
			ap.MenuProduto();
			return produto;
		}else {
			System.out.println("Produto não encontrado.");
			ap.LimparTela();
			ap.MenuProduto();
		}
		return null;
	}
	
	public void RemoverProduto() {
		Application ap = new Application();
		Produto produto = new Produto();
		int codigo;
		
		System.out.println("---------Remover Produto---------");
		System.out.println(" ");
		System.out.println("Código do Produto: ");

		codigo = scan.nextInt();
		produto.setCodigo_produto(codigo);
		
		if(produto.getCodigo_produto() != 0) {
			produtoDao.remover(produto);
			System.out.println("Produto removido com sucesso.");
			ap.LimparTela();
			ap.MenuProduto();
		}else {
			System.out.println("Produto não removido.");
			ap.LimparTela();
			ap.MenuProduto();
		}
		
		
	}
	
}
