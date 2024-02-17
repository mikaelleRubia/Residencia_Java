package aula01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		methoException();
		System.out.println("Fim!");

		

	}
	
	public static void methoException() {
		Scanner sc = new Scanner(System.in);
		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position " + e);
			
		}catch (InputMismatchException e) {
			System.out.println("Input erro" + e);
		}
		
		sc.close();
	}

}
