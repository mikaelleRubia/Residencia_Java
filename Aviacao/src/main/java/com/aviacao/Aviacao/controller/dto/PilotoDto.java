package com.aviacao.Aviacao.controller.dto;

public class PilotoDto {
	
	private String nome;
	private String numbreve;
	
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
	public PilotoDto(String nome, String numbreve) {
		super();
		this.nome = nome;
		this.numbreve = numbreve;
	}
	public PilotoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
