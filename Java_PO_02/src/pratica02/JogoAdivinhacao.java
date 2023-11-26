package pratica02;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
	private int numeroAleatorio;
	private int numeroPalpite;
	
	public JogoAdivinhacao() {
		super();
		Random random = new Random();
		this.numeroAleatorio = random.nextInt(100) + 1;
	}
	public int getNumeroAleatorio() {
		return numeroAleatorio;
	}
	public void setNumeroAleatorio(int numeroAleatorio) {
		this.numeroAleatorio = numeroAleatorio;
	}
	public int getNumeroPalpite() {
		return numeroPalpite;
	}
	public void setNumeroPalpite(int numeroPalpite) {
		this.numeroPalpite = numeroPalpite;
	}
	
	public void adivinhaNumero() {
		Scanner sc = new Scanner(System.in);
		
        System.out.println("Bem-vindo ao Jogo de Adivinhação!");
        System.out.println("Tente adivinhar o número entre 1 e 100.");
        
		do {
            System.out.println("Digite seu palpite: ");
            this.numeroPalpite = sc.nextInt();

            if (this.numeroPalpite > this.numeroAleatorio) {
                System.out.println("Muito alto. Tente novamente!\n");
            } else if (this.numeroPalpite < this.numeroAleatorio) {
                System.out.println("Muito baixo. Tente novamente!\n");
            } else {
                System.out.println("Parabéns! Você acertou.");
            }

        } while (this.numeroPalpite != this.numeroAleatorio);

        sc.close();

	}
	
}
