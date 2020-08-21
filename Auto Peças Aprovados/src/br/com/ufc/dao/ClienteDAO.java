package br.com.ufc.dao;

import java.sql.*;

import br.com.ufc.model.Cliente;
import br.com.ufc.connection.ConnectionPSQL;

public class ClienteDAO {

	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public ClienteDAO(ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
	}
	
	public boolean inserir(Cliente cliente) {
		String sql = "INSERT INTO cliente (nome, cpf, endereço, telefone) VALUES (?, ?, ?, ?);";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//insert into Cliente
			PreparedStatement std = connection.prepareStatement(sql);
			std.setString(1, cliente.getNome());
			std.setString(2, cliente.getCpf());
			std.setString(3, cliente.getEndereco());
			std.setString(4, cliente.getTelefone());
			
			int execucao = std.executeUpdate();
			
			//System.out.println(execucao);
			
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
	
	public boolean remover(Cliente cliente) {
		String sql = "DELETE FROM cliente WHERE cpf = ?;";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Remove from Cliente
			PreparedStatement std = connection.prepareStatement(sql);
			std.setString(1, cliente.getCpf());
			
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
	
	public Cliente buscar(String cpf) {
		String sql = "SELECT * FROM cliente WHERE cpf = ?;";
		Cliente cliente = new Cliente();
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Buscar cliente
			PreparedStatement std = connection.prepareStatement(sql);
			std.setString(1, cpf);
			
			ResultSet resultado = std.executeQuery();
			
			while(resultado.next()) {
				
				cliente.setNome(resultado.getString("nome"));;
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setEndereco(resultado.getString("endereço"));
				cliente.setTelefone(resultado.getString("telefone"));
				//System.out.println(cliente.toString());
				
				
				if(resultado.getFetchSize() > 0) {
					return cliente;
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
		return cliente;
	}
	
	}
	
}
