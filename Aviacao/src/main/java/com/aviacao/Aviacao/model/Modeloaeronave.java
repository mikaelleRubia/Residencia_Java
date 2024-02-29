package com.aviacao.Aviacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Modeloaeronave {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fabricante;
	private String nome;
	
	
	public Modeloaeronave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Modeloaeronave(Long id, String fabricante, String nome) {
		super();
		this.id = id;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
