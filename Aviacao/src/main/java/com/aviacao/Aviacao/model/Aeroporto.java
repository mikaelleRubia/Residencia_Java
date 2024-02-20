package com.aviacao.Aviacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aeroporto {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ICAO;
	private String Nome;
	
	public Aeroporto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Aeroporto(String iCAO, String nome) {
		super();
		ICAO = iCAO;
		Nome = nome;
	}
	public String getICAO() {
		return ICAO;
	}
	public void setICAO(String iCAO) {
		ICAO = iCAO;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	
}
