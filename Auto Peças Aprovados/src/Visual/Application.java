package Visual;

import java.text.ParseException;
import java.util.Scanner;
import br.com.ufc.controller.*;
import br.com.ufc.model.*;

public class Application {
	
	private ClienteControl conCliente = new ClienteControl();
	private FornecedorControl conFornecedor =  new FornecedorControl();
	private FuncionarioControl conFuncionario = new FuncionarioControl();
	private ProdutoControl conProduto = new ProdutoControl();
	private EstoqueControl conEstoque = new EstoqueControl();
	private VendaControl conVenda = new VendaControl();
	
	public Application () {
		
	}
	
	
	public void MenuPrincipal() {
		int op = 0;
		LimparTela();
		System.out.println("\n---------Menu Principal---------");
		System.out.println("\n   1 - Menu Cliente.");
		System.out.println("   2 - Menu Funcionario.");
		System.out.println("   3 - Menu Fornecedor.");
		System.out.println("   4 - Menu Produto.");
		System.out.println("   5 - Menu Estoque.");
		System.out.println("   6 - Sistema de Vendas.");
		System.out.println("   9 - Sair.");
		System.out.println("\n----Escolha a Opção desejada----");
		Scanner scan = new Scanner(System.in);
		op = scan.nextInt();
		do {
			if(op == 1) MenuCliente();
			if(op == 2) MenuFuncionario();
			if(op == 3) MenuFornecedor();
			if(op == 4) MenuProduto();
			if(op == 5) MenuEstoque();
			if(op == 6) MenuVenda();
			if(op == 9) {
				LimparTela();
				LimparTela();
				System.out.println("\n\n Obrigado por sua presença.\n\n ");
				System.out.println("\n\n Desconectado com sucesso. \n\n");
				op = -1;
				break;
			}
			
		}while(op >= 0);
	}
	
	public void MenuCliente() {
		int op = 0;
		LimparTela();
		System.out.println("\n---------Menu Cliente----------");
		System.out.println("\n   1 - Cadastrar Cliente.");
		System.out.println("   2 - Remover Cliente.");
		System.out.println("   3 - Buscar Cliente.");
		System.out.println("   9 - Voltar.");
		System.out.println("\n----Escolha a opção desejada----");
		Scanner scan = new Scanner(System.in);
		op = scan.nextInt();
		
		do {
			if(op == 1) conCliente.CadastrarCliente();
			if(op == 2) conCliente.RemoverCliente();
			if(op == 3) conCliente.BuscarCliente();
			if(op == 9) MenuPrincipal();
		}while(op >= 0);
	}
	
	public void MenuFuncionario() {
		int op = 0;
		LimparTela();
		System.out.println("\n---------Menu Funcionario---------");
		System.out.println("\n   1 - Cadastrar Funcionario.");
		System.out.println("   2 - Remover Funcionario.");
		System.out.println("   3 - Buscar Funcionario.");;
		System.out.println("   9 - Voltar.");
		System.out.println("\n-----Escolha a opção desejada-----");
		Scanner scan = new Scanner(System.in);
		op = scan.nextInt();
		
		do {
			if(op == 1) conFuncionario.CadastrarFuncionario();
			if(op == 2) conFuncionario.RemoverFuncionario();
			if(op == 3) conFuncionario.BuscarFuncionario();
			if(op == 9) MenuPrincipal();
		}while(op >= 0);
	}
	
	public void MenuFornecedor() {
		int op = 0;
		LimparTela();
		System.out.println("\n---------Menu Fornecedor---------");
		System.out.println("\n   1 - Cadastrar Fornecedor.");
		System.out.println("   2 - Remover Fornecedor.");
		System.out.println("   3 - Buscar Fornecedor.");;
		System.out.println("   9 - Voltar");
		System.out.println("\n----Escolha a opção desejada----");
		Scanner scan = new Scanner(System.in);
		op = scan.nextInt();
		
		do {
			if(op == 1) conFornecedor.CadastrarFornecedor();
			if(op == 2) conFornecedor.RemoverFornecedor();
			if(op == 3) conFornecedor.BuscarFornecedor();
			if(op == 9) MenuPrincipal();
		}while( op >= 0);
	}

	public void MenuProduto() {
		int op = 0;
		LimparTela();
		System.out.println("\n---------Menu Produto---------");
		System.out.println("\n   1 - Cadastrar Produto.");
		System.out.println("   2 - Remover Produto.");
		System.out.println("   3 - Buscar Produto.");
		System.out.println("   9 - Voltar.");
		System.out.println("\n---Escolha a opção desejada---");
		Scanner scan = new Scanner(System.in);
		op = scan.nextInt();
		
		do {
			if(op == 1) conProduto.CadastrarProduto();
			if(op == 2) conProduto.RemoverProduto();
			if(op == 3) conProduto.BuscarProduto();
			if(op == 9) MenuPrincipal();
		}while( op >= 0);
	}
	
	public void MenuEstoque() {
		int op = 0;
		LimparTela();
		System.out.println("\n------------Menu Estoque------------");
		System.out.println("\n   1 - Adicionar item ao estoque.");
		System.out.println("   2 - Remover item do estoque.");
		System.out.println("   3 - Buscar item no estoque.");
		System.out.println("   9 - Voltar");
		System.out.println("\n------Escolha a opção desejada------");
		Scanner scan = new Scanner(System.in);
		op = scan.nextInt();
		
		do {
			if(op == 1) conEstoque.AdicionarItem();
			if(op == 2) conEstoque.RemoverItem();
			if(op == 3) conEstoque.BuscarItem();
			if(op == 9) MenuPrincipal();
		}while(op > 0);
	}
	
	public void MenuVenda() {
		int op = 0;
		LimparTela();
		System.out.println("\n-------------Menu Venda-------------");
		System.out.println("\n   1 - Realizar Venda.");
		System.out.println("   2 - Buscar venda.");
		System.out.println("   9 - Voltar.");
		System.out.println("\n------Escolha a opção desejada------");
		Scanner scan = new Scanner(System.in);
		op = scan.nextInt();
		
		do {
			if(op == 1) conVenda.RealizarVenda();
			if(op == 2) conVenda.BuscarVenda();
			if(op == 9) MenuPrincipal();
		}while(op > 0);
	}
	
	public void LimparTela() {
		int i = 0;
		while(i < 18) {
			System.out.println(" ");
			i ++;
		}
	}
	
	
}


