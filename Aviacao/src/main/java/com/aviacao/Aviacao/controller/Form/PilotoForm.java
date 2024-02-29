package com.aviacao.Aviacao.controller.Form;

import com.aviacao.Aviacao.model.Piloto;

public class PilotoForm {

	private String nome;
	private String numbreve;
	
	
	public PilotoForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PilotoForm(String nome, String numbreve) {
		super();
		this.nome = nome;
		this.numbreve = numbreve;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumbreve() {
		return numbreve;
	}
	public void setNumbreve(String numbreve) {
		this.numbreve = numbreve;
	}
	
	public Piloto toPiloto() {
		
		return new Piloto(null, nome, numbreve);
	}
	
}
