package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
	
	public static boolean create(Cliente cliente) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "INSERT INTO Cliente (nome, cpf) VALUES (?, ?)";
		try(PreparedStatement preparedStatement = con.prepareStatement(query)){
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());

			preparedStatement.execute();
//			System.out.println(preparedStatement.toString());
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao adicionar o cliente" + e);
			return false;
		}
	}
	
	public static boolean update(Cliente cliente) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "UPDATE Cliente  SET nome = ?, cpf= ? WHERE nome = ?";
		try(PreparedStatement preparedStatement = con.prepareStatement(query)){
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNome());

			preparedStatement.execute();
//			System.out.println(preparedStatement.toString());
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao adicionar o cliente" + e);
			return false;
		}
	}
	
	public static boolean delete(Cliente cliente) {
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "DELETE FROM Cliente WHERE nome = ?";
		try(PreparedStatement preparedStatement = con.prepareStatement(query)){
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.execute();
			return true;
		}catch(SQLException e) {
			System.out.println("Erro ao remover o cliente" + e);
			return false;
		}
	}
	
	public static ArrayList<Cliente> readAll() throws Exception {
		
		ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
		
		DAO dao = new DAO();
		Connection con = dao.conectar();
		String query = "SELECT nome, cpf FROM Cliente";

		try(PreparedStatement ps = con.prepareStatement(query)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				listaCliente.add(cliente);
			}
			
		}catch(SQLException e) {
			System.out.println("Erro ao adicionar o cliente" + e);
		}
		return listaCliente;
	}
	
	public static Cliente readById(int id) throws Exception {
	    DAO dao = new DAO();
	    Connection con = dao.conectar();
	    String query = "SELECT id, nome, cpf FROM Cliente WHERE id = ?";
	    
	    try (PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
	            
	            return cliente;
	        } else {
	            System.out.println("Nenhum dado encontrado para o nome informado: " + id);
	            return null;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao adicionar o cliente: " + e);
	        return null;
	    }
	}

	public static void main(String[] args) throws Exception {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		Cliente client1 = new Cliente("Ana maria", "12345678999");
		Cliente client2 = new Cliente("Beatriz", "11145678999");
		Cliente client3 = new Cliente("Pedro", "12345678900");
		Cliente client4 = new Cliente();
		
//		create(client1);
//		create(client2);
//		create(client3);
		
		listaClientes = readAll();
//		
//		for(Cliente cliente : listaClientes) {
//			System.out.println(cliente.toString());
//		}
		client4 = readById(3);
		System.out.println(client4.toString());
		
		
//		client4 = readById(4);
//		delete(client4);
		
		for(Cliente cliente : listaClientes) {
		System.out.println(cliente.toString());
	}
		
		

	}

}
