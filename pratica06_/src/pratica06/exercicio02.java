package pratica06;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;



public class exercicio02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//		String[] lines = new String [] {"bom dia", " boa tarde", "boa noite"};
		List<String> lines02 = new ArrayList<>();
		char resposta;
		
		
		String file = ("/home/mikaelle/Documents/Residencia/cloneRepositorio/Residencia_Java/pratica06_/inserirDados.txt");
		Scanner sc = new Scanner(System.in);


		
		 try(BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
			 do {
				 
				System.out.println("Deseja a string para ser adicionado no arquivo");
                String input = sc.next();
                lines02.add(input);

				 
				System.out.println("Deseja inserir outra string (S/N)");
				resposta = Character.toUpperCase(sc.next().charAt(0));
			 
			 }while(resposta =='S');
			 for(String line : lines02) {
				 br.write(line);
				 br.newLine(); 
			 }
		 }
		 catch(IOException e) {
			 System.out.println("error: "+ e.getMessage());
		 } 
	}

}
