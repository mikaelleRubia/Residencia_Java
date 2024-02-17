package pratica04;

import java.util.ArrayList;

public class Calculadora {


    public static int somar(int a, int b) {
        return a + b;
    }

    public static int subtrair(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static int dividir(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
    }


    public static float somar(float a, float b) {
        return a + b;
    }

    public static float subtrair(float a, float b) {
        return a - b;
    }

    public static float multiplicar(float a, float b) {
        return a * b;
    }

    public static float dividir(float a, float b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
    }


    public static int somar(ArrayList<Integer> numeros) {
        int resultado = 0;
        try {
        	for (int num : numeros) {
        		resultado += num;
        	}
	    } catch (NullPointerException e) {
	        System.out.println("Erro: Tentativa de adicionar valor nulo à lista."+ e);
	        return 0;
	       
	    }
        return resultado;
    }

    public static int multiplicar(ArrayList<Integer> numeros) {
        int resultado = 1;
        try {
	        for (int num : numeros) {
	            resultado *= num;
	        }
	        
	    } catch (NullPointerException e) {
	        System.out.println("Erro: Tentativa de adicionar valor nulo à lista."+ e);
	        return 0;
	    }
        return resultado;
    }


    public static void main(String[] args) {

        System.out.println("Operações com inteiros:");
        System.out.println("Soma: " + somar(5, 3));
        System.out.println("Subtração: " + subtrair(5, 3));
        System.out.println("Multiplicação: " + multiplicar(5, 3));
        System.out.println("Divisão: " + dividir(5, 3));

        
        System.out.println("\nOperações com floats:");
        System.out.println("Soma: " + somar(5.0f, 3.0f));
        System.out.println("Subtração: " + subtrair(5.0f, 3.0f));
        System.out.println("Multiplicação: " + multiplicar(5.0f, 3.0f));
        System.out.println("Divisão: " + dividir(5.0f, 3.0f));


        System.out.println("\nOperações com ArrayList de inteiros:");
        ArrayList<Integer> numeros = new ArrayList<>();

    	numeros.add(2);
    	numeros.add(4);
    	numeros.add(null);
        	
        System.out.println("Soma: " + somar(numeros));
        System.out.println("Multiplicação: " + multiplicar(numeros));
    }
}
