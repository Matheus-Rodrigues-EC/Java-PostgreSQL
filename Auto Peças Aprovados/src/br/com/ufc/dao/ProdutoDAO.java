package br.com.ufc.dao;

import java.sql.*;

import br.com.ufc.model.Cliente;
import br.com.ufc.model.Produto;
import br.com.ufc.connection.ConnectionPSQL;

public class ProdutoDAO {

	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public ProdutoDAO(ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
	}
	
	public boolean inserir(Produto produto) {
		String sql = "INSERT INTO produto (cod_produto, nome, cod_fornecedor, preco) VALUES (?, ?, ?, ?);";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//insert into Produto
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt		(1, produto.getCodigo_produto());
			std.setString	(2, produto.getNome());
			std.setInt		(3, produto.getCodigo_fornecedor());
			std.setFloat	(4, produto.getPreco());
			
			int execucao = std.executeUpdate();
			if(execucao > 0) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean AtualizarPreco(Produto produto) {
		String sql = "UPDATE produto"
				   + "SET preco = ? "
				   + "WHERE cod_produto = ? ;";
		
		Produto produto1 = this.buscar(produto.getCodigo_produto());
		
		try {
			this.connection = connectionPSQL.getConnection();
			//UPDATE from produto
			PreparedStatement std = connection.prepareStatement(sql);
			std.setFloat(1, produto.getPreco());
			std.setInt(2, produto1.getCodigo_produto());
			
			int execucao = std.executeUpdate();			
			if(execucao > 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean remover(Produto produto) {
		String sql1 = "SELECT * FROM produto WHERE cod_produto = ?";
		String sql2 = "DELETE FROM produto WHERE cod_produto = ?;";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Remove from Produto
			PreparedStatement std = connection.prepareStatement(sql1);
			std.setInt(1, produto.getCodigo_produto());
			ResultSet resultado = std.executeQuery();
			while(resultado.next()) {
				int std2 = resultado.getInt("cod_produto");
				std = connection.prepareStatement(sql2);
				std.setInt(1, produto.getCodigo_produto());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Produto buscar(Integer cod_produto) {
		String sql = "SELECT * FROM produto WHERE cod_produto = ?;";
		Produto produto = new Produto();
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Buscar cliente
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, cod_produto);
			
			ResultSet resultado = std.executeQuery();
			
			while(resultado.next()) {
				
				produto.setCodigo_produto(resultado.getInt("cod_produto"));
				produto.setNome(resultado.getString("nome"));
				produto.setCodigo_fornecedor(resultado.getInt("cod_fornecedor"));
				produto.setPreco(resultado.getFloat("preco"));
				
				//System.out.println();
				
				if(resultado.getFetchSize() > 0) {
					return produto;
				}else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}
	
	}
}
