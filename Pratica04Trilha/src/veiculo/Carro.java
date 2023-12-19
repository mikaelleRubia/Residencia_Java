package veiculo;

class Carro extends Veiculo {
    public Carro(String modelo, String cor, int ano) {
        super(modelo, cor, ano);
    }

 
    public void abrirPorta() {
        System.out.println("Porta do carro aberta");
    }


    @Override
    public void acelerar() {
        System.out.println("Carro acelerando");
    }
}