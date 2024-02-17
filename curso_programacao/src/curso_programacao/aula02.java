package curso_programacao;
import java.util.Scanner;

public class aula02 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// casting -> conversão explicitas de tipos de dados
		int a, b;
		double resultado;
		a =5;
		b=2;
		resultado = (double) a /b ;
		
//		System.out.println(resultado);
		
		
		//entrada de dados (scanner)
		// string next(), int nextInt(), double nextDouble(), tipo char next().chatAt(0);, para pegar 2 palavras e quebra de linha nextLine()
		Scanner sc = new Scanner(System.in);
		
		String nome;

		System.out.println("Digite seu nome");
		nome = sc.nextLine();

		System.out.println("Seu nome é " + nome);
		sc.close();
		
	}

}
