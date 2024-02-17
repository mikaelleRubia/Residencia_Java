package validador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException  {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite a data de nascimento 'dd/MM/yyyy' ");
		Date checkinUpdate = sdf.parse(sc.next());
		ValidadorIdade idade = new ValidadorIdade(checkinUpdate);
		
		System.out.println(idade.getDataNascimento());
	}

}
