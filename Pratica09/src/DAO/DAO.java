package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private static final String URL = "jdbc:mysql://ud6wojm1kipj2b9q:AnfzvfjDej93h8RWefJw@bjbluaee8mfoagb4flsi-mysql.services.clever-cloud.com:3306/bjbluaee8mfoagb4flsi";
	private static final String USER = "ud6wojm1kipj2b9q";
	private static final String PASSWD = "AnfzvfjDej93h8RWefJw";
	
	
	
	public static Connection conectar() {
		Connection con = null;
		try {
			con= DriverManager.getConnection(URL,USER, PASSWD);
			System.out.println("conexão feita com sucesso pratica09");
		}catch(SQLException e) {
			System.out.println("Erro na conexão ");
	
		}
		return con;
		
	}
	
	 public static void main(String[] args) {
		 
		 conectar();
	 }
	 
}
