package com.example.pratica14.pratica14_mika.controller.Form;

import com.example.pratica14.pratica14_mika.model.Leilao;

public class LeilaoForm {

	private String descricao;
	private double valorminimo;
	private String status;
	
	
	public  LeilaoForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  LeilaoForm( String descricao, double valorMinimo, String status) {
		super();

		this.descricao = descricao;
		this.valorminimo = valorMinimo;
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorMinimo() {
		return valorminimo;
	}
	public void setValorMinimo(double valorMinimo) {
		this.valorminimo = valorMinimo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Leilao criarLeilao() {
		return new Leilao(null, descricao, valorminimo, status);
	}
}
