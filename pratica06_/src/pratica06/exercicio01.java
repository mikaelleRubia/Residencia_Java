package pratica06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class exercicio01 {

	 public static void main(String[] args) throws FileNotFoundException {
		 File file = new File("/home/mikaelle/eclipse-workspace/pratica06/entrada.txt");
		 
		 Scanner sc = new Scanner(file);

		 while(sc.hasNextLine()) {
			 System.out.println(sc.nextLine());
		 }
		 //se der tudo certo, entra no if e fecha o scanner
		 if( sc !=null) {
			 sc.close();
		 }
	 }
}
