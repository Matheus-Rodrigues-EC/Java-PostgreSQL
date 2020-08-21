package br.com.ufc.dao;

import java.sql.*;

import br.com.ufc.model.Fornecedor;
import br.com.ufc.connection.ConnectionPSQL;

public class FornecedorDAO {
	
	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public FornecedorDAO (ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
	}
	
	public boolean inserir(Fornecedor fornecedor) {
		String sql = "INSERT INTO fornecedor(cod_fornecedor, cnpj, nome, telefone) VALUES (?, ?, ?, ?);";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Inserir into Fornecedor
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, fornecedor.getCodigo_fornecedor());
			std.setString(2, fornecedor.getCnpj());
			std.setString(3, fornecedor.getNome());
			std.setString(4, fornecedor.getTelefone());
			
			int execucao = std.executeUpdate();
			
			if(execucao > 0) {
				return true;
			}else {
				return false;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean remover(Fornecedor fornecedor) {
		String sql = "DELETE FROM fornecedor WHERE cod_fornecedor = ?;";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//remove from fornecedor
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, fornecedor.getCodigo_fornecedor());
			
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
	
	public Fornecedor buscar(Integer cod_fornecedor) {
		String sql = "SELECT * FROM fornecedor WHERE cod_fornecedor = ?;";
		Fornecedor fornecedor = new Fornecedor();
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Buscar Fornecedor
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, cod_fornecedor);
			
			ResultSet resultado = std.executeQuery();
			
			while(resultado.next()) {
				
				fornecedor.setCodigo_fornecedor(resultado.getInt("cod_fornecedor"));
				fornecedor.setCnpj(resultado.getString("cnpj"));
				fornecedor.setNome(resultado.getString("nome"));
				fornecedor.setTelefone(resultado.getString("telefone"));
				
				if(resultado.getFetchSize() > 0) {
					return fornecedor;
				}else {
					return null;
				}
				
				}
			}catch (SQLException e) {
					e.printStackTrace();
			}finally {
			try {connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return fornecedor;
			}
	
	}	
	
	
}
