package aula08;

import java.util.ArrayList;

public class Cliente {
	
	 private String nome;
	 private String cpf;
	 private String cnh;
	 private String dataNascimento;
	 private ArrayList<String> telefone = new ArrayList<>();
	 
	 
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Cliente(String nome, String cpf, String cnh, String dataNascimento, ArrayList<String> telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}


	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public ArrayList<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(ArrayList<String> telefone) {
		this.telefone = telefone;
	}

	 
}
