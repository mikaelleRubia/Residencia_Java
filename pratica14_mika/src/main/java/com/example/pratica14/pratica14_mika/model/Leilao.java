package com.example.pratica14.pratica14_mika.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Leilao {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private double valorminimo;
	private String status;
	
	
	public Leilao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Leilao(Long id, String descricao, double valorMinimo, String status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valorminimo = valorMinimo;
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
		return valorminimo;
	}
	public void setValorMinimo(double valorMinimo) {
		this.valorminimo = valorMinimo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
//		if(status != "Aberto" || status != "Fechado") {
//			
//		}
		this.status = status;
	}
	
	
	
	
}
