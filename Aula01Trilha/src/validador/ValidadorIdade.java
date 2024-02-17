package validador;

import java.util.Date;

public class ValidadorIdade extends Exceptions {
	private Date dataNascimento;

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public ValidadorIdade(Date dataNascimento) {
		super();
		Date now = new Date();
		int ano = now.getYear() - dataNascimento.getYear();
		
		if(ano > 0 && ano < 150) {
			this.dataNascimento = dataNascimento;
			
		}else {
			IdadeInvalidaException();
		}
		
	}
	

	
}
