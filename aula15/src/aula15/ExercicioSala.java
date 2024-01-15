package aula15;

import java.io.IOException;

import aula15.Cripto;
import aula15.CriptoText;

public class ExercicioSala {
	 public static void main(String[] args) {
		 String nome1 = args[0];
		 String nome2 = args[1];
		 String senha = args[2];
		 
		 System.out.println("Entrada :" + nome1);
		 System.out.println("Saida :"+ nome2);
		 try {
//	            Cripto.process(nome1, nome2, senha);
//	            Cripto.process(nome2, "testes"+nome1, senha);
	            CriptoText.process02(nome1, nome2, senha);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	        }
	 
	 }

}
