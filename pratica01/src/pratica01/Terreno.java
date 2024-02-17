package pratica01;
import java.util.Scanner;

public class Terreno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	double largura, comprimento, valor, area, valor_total;
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Digite o valor do terro:");
	valor = sc.nextDouble();
	
	System.out.println("Digite o largura:");
	largura = sc.nextDouble();
	
	System.out.println("Digite o comprimento:");
	comprimento =  sc.nextDouble();
	
	area = largura * comprimento;
	valor_total = valor * area;
	
	System.out.println("Area do terreno:" + area);
	System.out.println("valor do terreno:" + valor_total);
	}

}
