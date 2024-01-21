package projeto07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class exercicio01 {
	public static void main(String[] args) {
		//questão 01 e 02
        File file_ = new File("/home/mikaelle/eclipse-workspace/Filme/estudantes.json");
        Scanner scanner = new Scanner(System.in);

        
    	System.out.print("Quantos estudantes deseja inserir? ");
        int numEstudantes = scanner.nextInt();
        scanner.nextLine();
        
        try {
        	SalvarEstudanteList(file_, numEstudantes, scanner );
        	lerDados(file_);
        	
        } finally {
            scanner.close();  // Fechar o Scanner
        }
    }

    private static JSONObject salvarEstudante( Scanner scanner) {
    	
        System.out.print("Digite o nome do estudante: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do estudante: ");
        int idade = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha pendente

        System.out.print("Digite o curso do estudante: ");
        String curso = scanner.nextLine();

        JSONObject estudante = new JSONObject();
        estudante.put("Nome", nome);
        estudante.put("Idade", idade);
        estudante.put("Curso", curso);

        
        return estudante;
    }
    
    private static void SalvarEstudanteList( File file_, int numEstudantes, Scanner scanner ) {
        JSONArray listaEstudantes = new JSONArray();
        JSONObject estudante_ = new JSONObject();

        for (int i = 0; i < numEstudantes; i++) {
            estudante_ = salvarEstudante(scanner);
            System.out.println(estudante_.getString("Nome"));
            listaEstudantes.put(estudante_);
        }
        try (FileWriter arquivoJson = new FileWriter(file_)) {
            arquivoJson.write(listaEstudantes.toString(2));
            System.out.println("Dados dos estudantes foram gravados em 'estudantes.json'.");

            lerDados(file_);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();  // Fechar o Scanner
        }
    }

    private static void lerDados(File nomeArquivo) {
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
}
