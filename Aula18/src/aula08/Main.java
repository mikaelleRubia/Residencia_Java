package aula08;

import aula08.Cliente;
import aula08.ClienteJson;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> telefone = new ArrayList<>();
		telefone.add("73988119988");
		telefone.add("73988119900");
		telefone.add("71988119988");
		telefone.add("71988999988");
		
		Cliente cliente = new Cliente("ana", "1234567890", "123456","01/04/1992",telefone);
		Cliente cliente2 = new Cliente("ana", "1234567890", "123456","04/05/1993", telefone);
		Cliente cliente3 = new Cliente("ana", "1234567890", "123456","09/05/2000", telefone);
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		ClienteJson.salvaClientes(clientes, "clientes.json");
		
		ClienteJson.recuperaDados("clientes.json");
		
		System.out.println("Retordo de dados com dataNascimento no formato Date");
		ClienteJson.converteRestauraData("clientes.json");
	}

}
