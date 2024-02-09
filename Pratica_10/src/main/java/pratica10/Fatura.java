package pratica10;

import java.time.LocalDate;

public class Fatura {
    private Imovel imovel;
    private double ultimaLeitura;
    private double penultimaLeitura;
    private LocalDate dataEmissao;
    private double valorCalculado;
    private boolean quitada;
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
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
	public LocalDate getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public double getValorCalculado() {
		return valorCalculado;
	}
	public void setValorCalculado(double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}
	public boolean isQuitada() {
		return quitada;
	}
	public void setQuitada(boolean quitada) {
		this.quitada = quitada;
	}
	public Fatura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fatura(Imovel imovel, double ultimaLeitura, double penultimaLeitura, LocalDate dataEmissao,
			double valorCalculado, boolean quitada) {
		super();
		this.imovel = imovel;
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
		this.dataEmissao = dataEmissao;
		this.valorCalculado = valorCalculado;
		this.quitada = quitada;
	}
    
}
