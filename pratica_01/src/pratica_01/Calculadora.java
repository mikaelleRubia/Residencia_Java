package pratica_01;

public class Calculadora {
	private float valor01;
	private float valor02;
	private String operacao;
	
	public Calculadora() {
	}
	
	public Calculadora(int valor01, int valor02, String operacao) {
		super();
		this.valor01 = valor01;
		this.valor02 = valor02;
		this.operacao = operacao;
	}
	
	public float getValor01() {
		return valor01;
	}
	public void setValor01(float valor01) {
		this.valor01 = valor01;
	}
	public float getValor02() {
		return valor02;
	}
	public void setValor02(float valor02) {
		this.valor02 = valor02;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	

	public static float calcular(String operacao, float valor01, float valor02) {
        float resultado = 0;
        switch (operacao) {
            case "adição":
                resultado = valor01 + valor02;
                break;
            case "subtração":
                resultado = valor01 - valor02;
                break;
            case "multiplicação":
                resultado = valor01 * valor02;
                break;
            case "divisão":
                resultado = valor01 / valor02;
                break;
            default:
                System.out.println("Opção inválida.");
        }
        return resultado;
	}
}
