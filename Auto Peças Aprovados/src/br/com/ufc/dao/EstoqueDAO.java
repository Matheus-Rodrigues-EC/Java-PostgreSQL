package br.com.ufc.dao;

import java.sql.*;

import br.com.ufc.model.*;
import br.com.ufc.connection.*;

public class EstoqueDAO {

	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public EstoqueDAO(ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
	}
	
	public boolean Inserir(Estoque estoque) {
		String sql = "INSERT INTO estoque (cod_fornecedor, cod_produto, quantidade) values (?, ?, ?) ;";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//insert into estoque
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, estoque.getCodigo_fornecedor());
			std.setInt(2, estoque.getCodigo_produto());
			std.setInt(3, estoque.getQuantidade());
			
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
	
	public boolean Remover(Estoque estoque) {
		String sql = "DELETE FROM estoque WHERE cod_produto = ? ;";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//delete from estoque
			PreparedStatement std = connection.prepareStatement(sql);
			
			std.setInt(1, estoque.getCodigo_produto());
			
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
	
	public Estoque buscar(Integer cod_produto) {
		String sql = "SELECT * FROM estoque WHERE cod_produto = ?;";
		Estoque item = new Estoque();
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Buscar cliente
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, cod_produto);
			
			ResultSet resultado = std.executeQuery();
			
			while(resultado.next()) {
				
				item.setCodigo_fornecedor(resultado.getInt("cod_fornecedor"));
				item.setCodigo_produto(resultado.getInt("cod_produto"));
				item.setQuantidade(resultado.getInt("quantidade"));
				
				//System.out.println();
				
				if(resultado.getFetchSize() > 0) {
					return item;
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
		return item;
	}
	
	}

	
	
}
