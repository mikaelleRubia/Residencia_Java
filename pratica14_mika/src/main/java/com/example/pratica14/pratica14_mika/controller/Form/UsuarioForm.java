package com.example.pratica14.pratica14_mika.controller.Form;

import com.example.pratica14.pratica14_mika.model.Usuario;

public class UsuarioForm {
	private String name;
	private String email;
	private String senha;
	
	public UsuarioForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioForm(String name, String email, String senha) {
		super();
		this.name = name;
		this.email = email;
		this.senha = senha;
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
	
	public Usuario criarUsuario() {
		return new Usuario(null, name, email, senha);
	}
	
}
