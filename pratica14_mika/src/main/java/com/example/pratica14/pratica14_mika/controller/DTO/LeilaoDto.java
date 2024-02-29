package com.example.pratica14.pratica14_mika.controller.DTO;

public class LeilaoDto {
	private Long id;
	private String descricao;
	private double valorMinimo;
	private String status;
	
	
	public LeilaoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeilaoDto(Long id, String descricao, double valorMinimo, String status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valorMinimo = valorMinimo;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
