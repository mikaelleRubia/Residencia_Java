package pratica04;
import java.util.ArrayList;



class ItemPedido {
    String nome;
    double preco;

    public ItemPedido(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}


public class Pedido {
	
	private long numeroPedido;
	private String cpf;
	private ArrayList<ItemPedido> itens;
	
    public Pedido(int numeroPedido, String cpf) {
        this.numeroPedido = numeroPedido;
        this.cpf = cpf;
        this.itens = new ArrayList<>();
    }
    

    public void adicionarItem(String nome, double preco) {
        itens.add(new ItemPedido(nome, preco));
    }


    public void adicionarItem(ArrayList<ItemPedido> listaItens) {
        itens.addAll(listaItens);
    }


    public double calcularTotal(double percentualDesconto) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.preco;
        }
        double desconto = total * (percentualDesconto / 100);
        return total - desconto;
    }

    public double calcularTotal(int numeroPrestacoes, double taxaJuros) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.preco;
        }
        double juros = total * (taxaJuros / 100);
        return total + juros;
    }


    public void exibirInformacoes() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("CPF do Cliente: " + cpf);
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : itens) {
            System.out.println(item.nome + ": R$" + item.preco);
        }
    }
	
	
	

	public static void main(String[] args) {
		 Pedido pedidoComDesconto = new Pedido(1, "123.456.789-00");
        pedidoComDesconto.adicionarItem("Produto1", 50.0);
        pedidoComDesconto.adicionarItem("Produto2", 30.0);
        pedidoComDesconto.exibirInformacoes();
        System.out.println("Total com desconto à vista: R$" + pedidoComDesconto.calcularTotal(10.0));

        System.out.println("\n------------------------\n");

        
        Pedido pedidoAPrazo = new Pedido(2, "987.654.321-00");
        ArrayList<ItemPedido> listaItens = new ArrayList<>();
        listaItens.add(new ItemPedido("Produto3", 40.0));
        listaItens.add(new ItemPedido("Produto4", 25.0));
        pedidoAPrazo.adicionarItem(listaItens);
        pedidoAPrazo.exibirInformacoes();
        System.out.println("Total a prazo: R$" + pedidoAPrazo.calcularTotal(3, 5.0));

	}

}
