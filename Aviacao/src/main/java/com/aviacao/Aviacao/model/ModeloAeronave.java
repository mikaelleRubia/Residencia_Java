package com.aviacao.Aviacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModeloAeronave {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fabricante;
	private String nome;
	
	
	public ModeloAeronave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModeloAeronave(String fabricante, String nome) {
		super();
		this.fabricante = fabricante;
		this.nome = nome;
	}
	public String getFabricante() {
		return this.fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
