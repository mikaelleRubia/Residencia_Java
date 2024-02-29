package com.example.pratica14.pratica14_mika.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Concorrente {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String CPF;
	

	
	public Concorrente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Concorrente(Long id, String nome, String cPF) {
		super();
		this.id = id;
		this.nome = nome;
		CPF = cPF;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	
	
}
