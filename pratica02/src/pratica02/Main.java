package pratica02;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		double valor = 0.0, count = 0.0;
		
//		System.out.println("Digite um valor");
//		valor = sc.nextInt();
//		
//		while(valor !=0) {
//			count += valor;
//			System.out.println("Digite novamente um valor");
//			valor = sc.nextInt();
//			
//		}
		
		System.out.println("Valor de count: "+ count);
		
		char res;
		
		for(int i = 5; i >=0; i--) {
			System.out.println("valor: " + i);
		}
		
		do {
			
			System.out.println("Digite a temperatura em Celsius: ");
			valor = sc.nextInt();
			
			count  = valor * 1.8 + 32;
			
			System.out.printf("Valor de count: %.2f%n", count);
			
			System.out.println("Deseja repetir?(s/n");
			res = sc.next().charAt(0);
			
		}while(res == 's');
		
		System.out.println("Fim");

	}

}
