package aula08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClienteJson {
	

	static void salvaClientes(ArrayList<Cliente> clientes, String nomeArquivo) {
		 JSONArray listaCliente = new JSONArray();
		 for(Cliente cliente : clientes) {
			 JSONObject cliente_ = dadosCliente(cliente);
			 listaCliente.put(cliente_);
		 }

		 try (FileWriter arquivoJson = new FileWriter(nomeArquivo)) {
	            arquivoJson.write(listaCliente.toString(2));
	            System.out.println("Dados dos cliente foram gravados em 'clientes.json'.");
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	private static JSONArray AddListTelefone(ArrayList<String> telefones) {
	    JSONArray listaTelefone = new JSONArray();
	    for (String telefone : telefones) {
	        listaTelefone.put(telefone);
	    }

	    return listaTelefone;
	}
	
	private static JSONObject dadosCliente(Cliente client) {
		
		JSONObject clienteJson = new JSONObject();
		clienteJson.put("Nome", client.getNome());
		clienteJson.put("cpf", client.getCpf());
		clienteJson.put("cnh", client.getCnh());
		clienteJson.put("DataNascimento", client.getDataNascimento());
		clienteJson.put("Telefone",AddListTelefone(client.getTelefone()) );
		
		return clienteJson;	
	}
	
	static void recuperaDados(String nomeArquivo) {
		try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       
	}

	
	static void converteRestauraData(String nomeArquivo) {
		try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String line = br.readLine();
            while (line != null) {
                if (line.contains("DataNascimento")) {
                    String[] parts = line.split(":");

                    if (parts.length == 2) {
                        String valorDataNascimento = parts[1].trim().replace("\"", "");

                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate dataNascimento = LocalDate.parse(valorDataNascimento.trim().replaceAll("[^\\d/]", ""), formatter);
                            System.out.println("DataNascimento: " + dataNascimento);
                        } catch (DateTimeParseException e) {
                            System.out.println("Erro ao fazer o parsing da data: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Formato inválido da linha com DataNascimento: " + line);
                    }
                }else {
                	System.out.println(line);	
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       	
	}
	

}
