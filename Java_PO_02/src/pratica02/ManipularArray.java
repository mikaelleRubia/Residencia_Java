package pratica02;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ManipularArray {

    private ArrayList<Integer> numerosUsuario = new ArrayList<>();
    private ArrayList<Integer> numerosAleatorio = new ArrayList<>();

    public ArrayList<Integer> getNumerosUsuario() {
        return numerosUsuario;
    }

    public ArrayList<Integer> getNumerosAleatorio() {
        return numerosAleatorio;
    }

    public void addNumeroUsa(int tamanho) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            numerosUsuario.add(sc.nextInt());
        }
    }

    public void addNumeAleatorio(int tamanho) {
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            int numeroAleatorio_ = random.nextInt(100) + 1;
            numerosAleatorio.add(numeroAleatorio_);
        }
    }

    public int calcularSoma(ArrayList<Integer> array) {
        int soma = 0;
        for (int valor : array) {
            soma += valor;
        }
        return soma;
    }

    public int encontrarMaiorValor(ArrayList<Integer> array) {
        int maior = array.get(0);
        for (int valor : array) {
            if (valor > maior) {
                maior = valor;
            }
        }
        return maior;
    }

    public int encontrarMenorValor(ArrayList<Integer> array) {
        int menor = array.get(0);
        for (int valor : array) {
            if (valor < menor) {
                menor = valor;
            }
        }
        return menor;
    }

    private void imprimirArray(ArrayList<Integer> array) {
        System.out.print("[");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
            if (i < array.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManipularArray manipulador = new ManipularArray();

        System.out.print("Digite o tamanho do array: ");
        int tamanho = sc.nextInt();

        manipulador.addNumeAleatorio(tamanho);

 
        System.out.print("Array aleatório: ");
        manipulador.imprimirArray(manipulador.getNumerosAleatorio());

        int somaAleatorio = manipulador.calcularSoma(manipulador.getNumerosAleatorio());
        System.out.println("Soma do array aleatório: " + somaAleatorio);

        int maiorValorAleatorio = manipulador.encontrarMaiorValor(manipulador.getNumerosAleatorio());
        System.out.println("Maior valor do array aleatório: " + maiorValorAleatorio);

        int menorValorAleatorio = manipulador.encontrarMenorValor(manipulador.getNumerosAleatorio());
        System.out.println("Menor valor do array aleatório: " + menorValorAleatorio);
        
        
        
        manipulador.addNumeroUsa(tamanho);
        
        System.out.print("Array: ");
        manipulador.imprimirArray(manipulador.getNumerosUsuario());
        
        int somaNumeros = manipulador.calcularSoma(manipulador.getNumerosUsuario());
        System.out.println("Soma do array: " + somaNumeros);
        
        int numeroMaior =manipulador.encontrarMaiorValor(manipulador.getNumerosUsuario());
        System.out.println("Maior valor do array: " + numeroMaior);
        
        int numeroMenor = manipulador.encontrarMenorValor(manipulador.getNumerosUsuario());
        System.out.println("Maior valor do array aleatório: " + numeroMenor);
        
        
        
        
        
    }
}
