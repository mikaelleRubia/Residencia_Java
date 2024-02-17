package caixaEletronico;

public class CaixaEletronico extends ValorInvalidoException{

	private float saldo;

	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public CaixaEletronico( float saldo) {
		super();
		this.saldo = saldo;
	}
	
	public void sacar(float valorSacar) {
		
		if(valorSacar % 10 == 0) {
			if(getSaldo() > valorSacar) {
				this.setSaldo(getSaldo() - valorSacar);
			}else {
				System.out.println("valor insuficiente!");
			}
		}else {
			ValorInvalidoException();
		}
	}
	@Override
	public String toString() {
		return "CaixaEletronico [saldo=" + saldo + "]";
	}
	
	
	
	
}
