package veiculo;


class Moto extends Veiculo {
    public Moto(String modelo, String cor, int ano) {
        super(modelo, cor, ano);
    }


    public void empinar() {
        System.out.println("Moto empinando");
    }

    @Override
    public void parar() {
        System.out.println("Moto parada");
    }
    
}