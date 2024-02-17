package cliente;
import java.util.ArrayList;

public class ListaClientes {
	private static ArrayList<Cliente> lista_cliente = new ArrayList<Cliente>();
	
	public void criaCliente(Cliente cliente) {
		lista_cliente.add(cliente);
	}
	public void removerCliente(Cliente cliente) {
		lista_cliente.remove(cliente);
	}
	
	public Cliente consultarClientePorCPF(String cpf) {
        for (Cliente cliente : lista_cliente) {
            if (cliente.getCPF().equals(cpf)) {
                return cliente;
            }
        }
        return null; 
    }
	
	public void listarClientes() {
        System.out.println("===== Lista de Clientes =====");
        for (Cliente cliente : lista_cliente) {
            System.out.println("CPF: " + cliente.getCPF() + ", Nome: " + cliente.getNome());
        }
    }

    public boolean alterarCliente(String cpf, String novoNome) {
        Cliente clienteParaAlterar = consultarClientePorCPF(cpf);

        if (clienteParaAlterar != null) {
            clienteParaAlterar.setNome(novoNome);
            return true;
        } else {
            return false;
        }
    }
	
}
