package br.com.ufc.dao;

import java.sql.*;

import br.com.ufc.model.Venda;
import br.com.ufc.connection.ConnectionPSQL;

public class VendaDAO {

	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public VendaDAO(ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
		}
	
	
	public boolean inserir(Venda venda) {
		String sql = "INSERT INTO venda (cod_venda, cod_funcionario, cod_produto, quantidade) VALUES (?, ?, ?, ?);";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//insert into Cliente
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, venda.getCod_venda());
			std.setInt(2, venda.getCod_funcionario());
			std.setInt(3, venda.getCod_produto());
			std.setInt(4, venda.getQuantidade());
			
			int execucao = std.executeUpdate();
			
			System.out.println("\n\nO código de venda utilizado foi: " + venda.getCod_venda() + "\n\n");
			
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
	
	public boolean remover(Venda venda) {
		String sql = "DELETE FROM venda WHERE cod_venda = ?;";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Remove from Cliente
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, venda.getCod_venda());
			
			int execucao = std.executeUpdate();
			
			if(execucao > 0) {
				return true;
			}else {
				return false;
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

	public Venda buscar(Integer cod_venda) {
		String sql = "SELECT * FROM venda WHERE cod_funcionario = ?;";
		Venda venda = new Venda();
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Buscar cliente
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, cod_venda);
			
			ResultSet resultado = std.executeQuery();
			
			while(resultado.next()) {
				
				venda.setCod_venda(resultado.getInt("cod_venda"));
				venda.setCod_funcionario(resultado.getInt("cod_funcionario"));
				venda.setCod_produto(resultado.getInt("cod_produto"));
				venda.setQuantidade(resultado.getInt("quantidade"));
				//System.out.println(cliente.toString());
				
				
				if(resultado.getFetchSize() > 0) {
					return venda;
				}else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return venda;
	}
	
	}

}
