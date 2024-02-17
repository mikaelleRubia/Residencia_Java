package usuarios;

public class Usuarios {
	private String nome;
	private String senha;
	private String cpf;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public Usuarios(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	public Usuarios() {
	    this.nome = ""; 
	    this.senha = "";
	    this.cpf = ""; 

	}
	@Override
	public String toString() {
		return "Nome: " + nome + "\n senha: " + senha + "\n cpf: " + cpf +"\n" ;
	}

	

}