package pratica02;

public class ConverteMoeda {
	private double taxaCambio;
	private double qtdDolares;
	public ConverteMoeda() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getTaxaCambio() {
		return taxaCambio;
	}
	
	public void setTaxaCambio(double taxaCambio) {
		this.taxaCambio = taxaCambio;
	}
	
	public double getQtdDolares() {
		return qtdDolares;
	}
	
	public void setQtdDolares(double qtdDolares) {
		this.qtdDolares = qtdDolares;
	}
	
	public static double calculaConversaoMoeda(double quantidadeDolares_, double taxaCambio_) {
		double valorConvertido = quantidadeDolares_ * taxaCambio_;
		
		return valorConvertido;
	}
	
}
