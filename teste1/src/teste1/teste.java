package teste1;
import teste1.Carro;

public class teste {

	 public static void main(String[] args) {
	     Carro meuCarro = new Carro();
	     meuCarro.setModelo("Fusca");
	     meuCarro.setCor("Azul");
	     meuCarro.dirigir();
     
	     System.out.println(meuCarro.toString());
	     
	     
	 }

}

