package pratica10;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imovel {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer id;
	
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
	public Imovel(Integer id, String matricula, double ultimaLeitura, double penultimaLeitura, Cliente cliente) {
		super();
		this.id = null;
		this.matricula = matricula;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
		this.cliente = cliente;
	}
    
	 public static void main(String[] args) {
		 
	 }
	 }
    
}
