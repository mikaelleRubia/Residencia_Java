package com.example.pratica14.pratica14_mika.controller.DTO;

public class ConcorrenteDto {
	
	private Long id;
	private String nome;
	private String CPF;
	
	public ConcorrenteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConcorrenteDto(Long id, String nome, String cPF) {
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
