package pratico08;

public class Cliente {
	private String nome;
	
	private String cpf;
	   
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception {
		if(nome.length() < 3) {
            Exception e = new Exception("Nome deve ter mais de 2 caracteres");
            throw e;
		}
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws Exception {
		if(cpf.length() < 11) {
            Exception e = new Exception("CPF deve ter mais de 11 digitos");
            throw e;
		}
		this.cpf = cpf;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	   
	   
}
