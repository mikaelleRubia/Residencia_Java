package entities;

public class Product {
	
	public String nome;
	public int qtd;
	public double valor;
	
	
	public void addQtd(int qtd) {
		
		this.qtd +=qtd;
	}
	
	public double totalValor() {
		
		return valor*qtd;
	}
	
	public void removerQtd(int qtd) {
		this.qtd -= qtd;
	}

	@Override
	public String toString() {
		return "Product [nome=" + nome + ", qtd=" + qtd + ", valor=" + valor + "]";
	}
	
	

}
