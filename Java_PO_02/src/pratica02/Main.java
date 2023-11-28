package pratica02;
import java.util.Scanner;
import pratica02.ConverteMoeda;
import pratica02.JogoAdivinhacao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		JogoAdivinhacao jogo = new JogoAdivinhacao();
		
		ConverteMoeda cm = new ConverteMoeda();
		
		System.out.println("Digite a taxa de câmbio (por exemplo, 5.05 para converter de dólares para euros ou reais): ");
        cm.setTaxaCambio(scanner.nextDouble());

        System.out.println("Digite a quantidade em dólares: ");
        cm.setQtdDolares(scanner.nextDouble());

        double valorConvertido = ConverteMoeda.calculaConversaoMoeda(cm.getQtdDolares(), cm.getTaxaCambio());
    
        System.out.printf("O valor convertido é: %.2f%n", valorConvertido);
        
        
        //Questão02
       jogo.adivinhaNumero();

	}

}
