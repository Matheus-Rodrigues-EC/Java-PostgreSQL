package br.com.ufc.dao;

import java.sql.*;

import br.com.ufc.model.Fornecedor;
import br.com.ufc.model.Funcionario;
import br.com.ufc.connection.ConnectionPSQL;

public class FuncionarioDAO {

	private ConnectionPSQL connectionPSQL;
	private Connection connection;
	
	public FuncionarioDAO(ConnectionPSQL connectionPSQL) {
		this.connectionPSQL = connectionPSQL;
	}
	
	public boolean inserir(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario(nome, cpf, endereco, telefone, cargo, salario) "
				   + "VALUES (?, ?, ?, ?, ?, ?);";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//insert into funcionario
			PreparedStatement std = connection.prepareStatement(sql);
			std.setString	(1, funcionario.getNome());
			std.setString	(2, funcionario.getCpf());
			std.setString	(3, funcionario.getEndereco());
			std.setString	(4, funcionario.getTelefone());
			std.setString	(5, funcionario.getCargo());
			std.setFloat	(6, funcionario.getSalario());

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
	
	public boolean remover(Funcionario funcionario) {
		String sql = "DELETE FROM funcionario WHERE cod_funcionario = ?;";
		
		try {
			this.connection = connectionPSQL.getConnection();
			//remove from funcionario
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, funcionario.getCodigo_funcionario());
			
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
	
	public Funcionario buscar(Integer cod_funcionario) {
		String sql = "SELECT * FROM funcionario WHERE cod_funcionario = ?;";
		Funcionario funcionario = new Funcionario();
		
		try {
			this.connection = connectionPSQL.getConnection();
			//Buscar Fornecedor
			PreparedStatement std = connection.prepareStatement(sql);
			std.setInt(1, cod_funcionario);
			
			ResultSet resultado = std.executeQuery();
			
			while(resultado.next()) {
				
				funcionario.setCodigo_funcionario(resultado.getInt("cod_funcionario"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setCpf(resultado.getString("cpf"));
				funcionario.setEndereco(resultado.getString("endereco"));
				funcionario.setTelefone(resultado.getString("telefone"));
				funcionario.setCargo(resultado.getString("cargo"));
				funcionario.setSalario(resultado.getFloat("salario"));
				
				
				if(resultado.getFetchSize() > 0) {
					return funcionario;
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
			return funcionario;
			}
	
	}
	
	public boolean AtualizarCargo(Funcionario funcionario) {
		String sql = "UPDATE funcionario"
				   + "SET cargo = ? "
				   + "WHERE cod_funcionario = ? ;";
		
		Funcionario funcionario1 = this.buscar(funcionario.getCodigo_funcionario());
		
		try {
			this.connection = connectionPSQL.getConnection();
			//update cargo
			PreparedStatement std = connection.prepareStatement(sql);
			std.setString(1, funcionario.getCargo());
			std.setInt(2, funcionario1.getCodigo_funcionario());
			
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

	public boolean AtualizarSalario(Funcionario funcionario) {
		String sql = "UPDATE funcionario"
				   + "SET salario = ? "
				   + "WHERE cod_funcionario = ? ;";
		
		Funcionario funcionario1 = this.buscar(funcionario.getCodigo_funcionario());
		
		try {
			this.connection = connectionPSQL.getConnection();
			//update cargo
			PreparedStatement std = connection.prepareStatement(sql);
			std.setFloat(1, funcionario.getSalario());
			std.setInt(2, funcionario1.getCodigo_funcionario());
			
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
	
}