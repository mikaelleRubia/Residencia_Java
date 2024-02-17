package reparo;

import java.time.LocalDate;

public class Reparo {
	private String descricao;
	private LocalDate previsao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private boolean resolveu;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getPrevisao() {
		return previsao;
	}
	public void setPrevisao(LocalDate previsao) {
		this.previsao = previsao;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	public boolean isResolveu() {
		return resolveu;
	}
	public void setResolveu(boolean resolveu) {
	    this.resolveu = resolveu;
	    if (resolveu) {
	        this.dataFim = LocalDate.now();
	    }
	}
	public Reparo(String descricao, LocalDate previsao) {
		super();
		this.descricao = descricao;
		this.previsao = previsao;
		this.dataInicio = null;
		this.dataFim = null;
		this.resolveu = false;
	}
	
	
}
