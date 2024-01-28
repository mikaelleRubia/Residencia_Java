package pratico08;

public class Imovel {
    private String matricula;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private Cliente cliente;
    
    
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getUltimaLeitura() {
		return ultimaLeitura;
	}
	public void setUltimaLeitura(double ultimaLeitura) {
		this.ultimaLeitura = ultimaLeitura;
	}
	public double getPenultimaLeitura() {
		return penultimaLeitura;
	}
	public void setPenultimaLeitura(double penultimaLeitura) {
		this.penultimaLeitura = penultimaLeitura;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Imovel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Imovel(String matricula, double ultimaLeitura, double penultimaLeitura, Cliente cliente) {
		super();
		this.matricula = matricula;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
		this.cliente = cliente;
	}
    
    
}
