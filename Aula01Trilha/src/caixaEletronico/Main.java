package caixaEletronico;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaixaEletronico caixa = new CaixaEletronico(110);
		
		caixa.sacar(20);
		System.out.println(caixa.toString());
		
	}

}
