package projeto07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exercicio03 {
	private static final String ARQUIVO_DADOS = "/home/mikaelle/eclipse-workspace/Filme/estudantes_exercicio04.json";

    public static void main(String[] args) {
        List<String> dados = carregarDados();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Sistema de Persistência de Dados (Json)");
            char opcao;

            do {
                System.out.println("1. Inserir novo dado");
                System.out.println("2. Alterar dado existente");
                System.out.println("3. Excluir dado");
                System.out.println("4. Mostrar todos os dados");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = sc.next().charAt(0);
                sc.nextLine(); 

                switch (opcao) {
                    case '1':
                        System.out.println("Digite o novo dado: ");
                        String novoDado = sc.nextLine();
                        dados.add(novoDado);
                        salvarDados(dados);
                        break;
                    case '2':
                        System.out.print("Digite o índice da frase a ser alterada: ");
                        int indiceAlterar = sc.nextInt();
                        sc.nextLine();

                        if (indiceAlterar >= 0 && indiceAlterar < dados.size()) {
                            System.out.println("Digite a nova frase: ");
                            String novaFrase = sc.nextLine();
                            dados.set(indiceAlterar, novaFrase);
                            salvarDados(dados);
                            System.out.println("Frase alterada com sucesso.");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                        break;
                    case '3':
                        System.out.print("Digite o índice do dado a ser excluído: ");
                        int indiceExcluir = sc.nextInt();
                        if (indiceExcluir >= 0 && indiceExcluir < dados.size()) {
                            dados.remove(indiceExcluir);
                            salvarDados(dados);
                            System.out.println("Dado excluído com sucesso.");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                        break;
                    case '4':
                        mostrarDados(dados);
                        break;
                    case '5':
                        System.out.println("Saindo do programa.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } while (opcao != '5');
        }
    }

    private static List<String> carregarDados() {
        List<String> dados = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_DADOS))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                dados.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Arquivo não encontrado. Criando novo arquivo.");
            criarArquivo();
        }

        return dados;
    }

    private static void salvarDados(List<String> dados) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_DADOS))) {
            for (String dado : dados) {
                escritor.write(dado);
                escritor.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }

    private static void mostrarDados(List<String> dados) {
        System.out.println("Dados armazenados:");
        for (String dado : dados) {
            System.out.println(dado);
        }
    }

    private static void criarArquivo() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_DADOS))) {
            System.out.println("Novo arquivo criado.");
        } catch (IOException e) {
            System.err.println("Erro ao criar novo arquivo: " + e.getMessage());
        }
    }
}
