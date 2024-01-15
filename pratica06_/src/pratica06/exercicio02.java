package pratica06;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exercicio02 {

    public static void main(String[] args) throws IOException {
        List<String> lines02 = new ArrayList<>();
        String resposta;

        String file = ("/home/mikaelle/Documents/Residencia/cloneRepositorio/Residencia_Java/pratica06_/inserirDados.txt");
        Scanner sc = new Scanner(System.in);

        try (BufferedWriter br = new BufferedWriter(new FileWriter(file, true))) {
            do {
                System.out.println("Deseja a frase para ser adicionada no arquivo");
                String input = sc.nextLine();
                lines02.add(input);

                System.out.println("Deseja inserir outra frase (S/N)");
                resposta = sc.nextLine().toUpperCase();

            } while (resposta.equals("S"));

            for (String line : lines02) {
                br.write(line);
                br.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
