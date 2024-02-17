package application;
import java.util.Scanner;
import entities.Triangle;
import entities.Product;

public class Program {

	public static void main(String[] args) {

//		double result, resultY, maior;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		Triangle x, y; 
//		x =  new Triangle();
//		y = new Triangle();
//		
//		System.out.println("Digite os valor do trilagulo X");
//		x.A = sc.nextDouble();
//		x.B = sc.nextDouble();
//		x.C = sc.nextDouble();
//		
//		result = x.area();
//		
//		System.out.println("Digite os valor do trilagulo Y");
//		y.A = sc.nextDouble();
//		y.B = sc.nextDouble();
//		y.C = sc.nextDouble();
//		
//		resultY = y.area();
//		
//		maior = areaMaior(result, resultY);
//
//		System.out.println("Area do triangula X: " + result);
//		System.out.println("Area do triangula Y: " + resultY);
//		System.out.println("Maior: " + maior);
		
		Product prod1;
		
		prod1 = new Product();
		prod1.nome = "armario";
		prod1.qtd = 0;
		prod1.addQtd(10);
		prod1.addQtd(15);
		prod1.valor = 900.00;
		System.out.println( prod1.toString());
	}
	
	
	public static double areaMaior(double result1, double result2) {
		double aux = 0.0;
		
		if(result1 > result2) {
			aux = result1;
		}if(result2 > result1) {
			aux = result2;
		}
		
		return aux;
	}

}
