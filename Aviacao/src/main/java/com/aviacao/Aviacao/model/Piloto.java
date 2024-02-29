package com.aviacao.Aviacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Piloto {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String numbreve;
	

	public Piloto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Piloto(Long id, String nome, String numbreve) {
		super();
		this.id = id;
		this.nome = nome;
		this.numbreve = numbreve;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumBreve() {
		return numbreve;
	}
	public void setNumBreve(String numBreve) {
		numbreve = numBreve;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
