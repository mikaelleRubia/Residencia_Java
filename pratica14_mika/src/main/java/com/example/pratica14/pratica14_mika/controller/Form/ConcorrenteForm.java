package com.example.pratica14.pratica14_mika.controller.Form;

import com.example.pratica14.pratica14_mika.model.Concorrente;

public class ConcorrenteForm {
	private String nome;
	private String CPF;
	
	public ConcorrenteForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConcorrenteForm( String nome, String cPF) {
		super();

		this.nome = nome;
		CPF = cPF;
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
	
	public Concorrente criarConcorrente() {
		return new Concorrente(null, nome, CPF);
	}
}
