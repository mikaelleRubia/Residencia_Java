package pratica_01;
import java.util.Scanner;
import pratica_01.Convertor_temperatura;
import pratica_01.Calculadora;

public class Main {

	public static void main(String[] args) {
		// Questão Calculadora Simples
		Calculadora cal = new Calculadora(5, 3, "adição");
		Calculadora cal2 = new Calculadora();
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite um número 2");
		cal2.setValor01(sc.nextFloat());
		
		System.out.println("Digite outro número : ");
		cal2.setValor02(sc.nextFloat());
		
		System.out.println("escolha uma operação \n1 ->adição,\n2-> subtração,\n3-> multiplicação,\n4->divisão\n");
		cal2.setOperacao(sc.next());
		
		float resultado = Calculadora.calcular("adição", 5.0f, 3.0f);
		float resultado2 = Calculadora.calcular(cal2.getOperacao(), cal2.getValor01(), cal2.getValor02());
		
		System.out.println(resultado);
		System.out.println(resultado2);
		
		
		// Questão Conversor de Temperatura:
		Convertor_temperatura tem0 = new Convertor_temperatura(15, "Fahrenheit");
		Convertor_temperatura tem = new Convertor_temperatura(15, "Fahrenheit");
		
		System.out.println("Digite a temperatura : ");
		tem.setTemperatura(sc.nextFloat());
		
		System.out.println("Digite a unidade de origem: ");
		tem.setUnidade_origem(sc.next());
		
		float converteFah = Convertor_temperatura.converteFahrenheit(tem.getTemperatura());
		float converteCels = Convertor_temperatura.converteCelsius(tem.getTemperatura());
		
		if(tem.getUnidade_origem().equals("Celsius")) {
			System.out.println("Temperatura convertida para Fahrenheit: "+converteFah);
		}else if(tem.getUnidade_origem().equals("Fahrenheit")) {
			System.out.println("Temperatura convertida para Celsius: "+converteCels);
		}else {
			System.out.println("Unidade invalida");
		}
		
		sc.close();
		
	}

}
