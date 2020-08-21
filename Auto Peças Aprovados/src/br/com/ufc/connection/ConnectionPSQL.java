package br.com.ufc.connection;

import java.sql.*;

public class ConnectionPSQL {
	private final String ip = "localhost";
	private final Integer port = 5432;
	private final String user = "postgres";
	private final String password = "linha7BOLA";
	//private final String server = "FBD_EaD";
	private final String database = "Auto Pecas Aprovados";
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://"+ip+":"+port+"/"+database, user, password);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
}
