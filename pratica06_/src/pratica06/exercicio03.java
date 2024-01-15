package pratica06;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class exercicio03 {
  public static void main(String[] args) {
        String arquivoOrigem = "/home/mikaelle/Documents/Residencia/cloneRepositorio/Residencia_Java/pratica06_/origem.txt";
        String arquivoDestino = "/home/mikaelle/Documents/Residencia/cloneRepositorio/Residencia_Java/pratica06_/destino.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoOrigem));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoDestino, true))) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                escritor.write(linha);
                escritor.newLine();
            }

            System.out.println("Conteúdo do arquivo copiado com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}
