package cliente;

import java.util.List;

import empresa.Imovel;

import java.util.ArrayList;


public class Cliente {
	private String CPF;
	private String nome;
	private List<Imovel> imoveis;
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Imovel> getImoveis() {
		return imoveis;
	}
	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	public Cliente(String cPF, String nome) {
		super();
		CPF = cPF;
		this.nome = nome;
		this.imoveis = new ArrayList<>();
	}
	
	
	public void addImovel(Imovel imovel) {
		imoveis.add(imovel);
	}
	
}
