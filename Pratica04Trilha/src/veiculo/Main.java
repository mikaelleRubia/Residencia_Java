package veiculo;

public class Main {

    public static void main(String[] args) {

        Carro meuCarro = new Carro("Civic", "Prata", 2022);
        Moto minhaMoto = new Moto("Ninja", "Preto", 2021);


        System.out.println("Ações do Carro:");
        meuCarro.ligar();
        meuCarro.acelerar();
        meuCarro.parar();
        meuCarro.abrirPorta();

        System.out.println("\nAções da Moto:");
        minhaMoto.ligar();
        minhaMoto.acelerar();
        minhaMoto.parar();
        minhaMoto.empinar();
    }

}