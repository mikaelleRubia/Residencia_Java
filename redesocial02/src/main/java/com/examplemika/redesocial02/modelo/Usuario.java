package com.examplemika.redesocial02.modelo;

public class Usuario {
	private Long id;
	private String name;
	private String email;
	private String senha;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(Long id, String name, String email, String senha) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
