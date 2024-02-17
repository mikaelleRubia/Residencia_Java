package teste1;

public class Carro {
	
	private String modelo;
	private String cor;
	
	
	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + ", cor=" + cor + "]";
	}
	void dirigir() {
	   System.out.println("O carro está em movimento.");
	}
}