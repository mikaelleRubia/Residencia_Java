package reparo;
import java.util.ArrayList;

public class ListaReparos {
	private static ArrayList<Reparo> lista_reparo = new ArrayList<Reparo>();
	
	public void criaReparo(Reparo reparo) {
		lista_reparo.add(reparo);
	}
	public void removerCliente(Reparo reparo) {
		lista_reparo.remove(reparo);
	}
	
    public Reparo consultarReparoPorDescricao(String descricao) {
        for (Reparo reparo : lista_reparo) {
            if (reparo.getDescricao().equals(descricao)) {
                return reparo;
            }
        }
        return null;
    }
    
    
    public void listarReparos() {
        System.out.println("===== Lista de Reparos =====");
        for (Reparo reparo : lista_reparo) {
            System.out.println("Descrição: " + reparo.getDescricao() +
                               ", Previsão: " + reparo.getPrevisao() +
                               ", Resolvido: " + reparo.isResolveu());
        }
    }

    public void alterarReparo(String descricao, String novaDescricao) {
        Reparo reparoParaAlterar = consultarReparoPorDescricao(descricao);

        if (reparoParaAlterar != null) {
            reparoParaAlterar.setDescricao(novaDescricao);
            System.out.println("Descrição do reparo alterada com sucesso!");
        } else {
            System.out.println("Reparo não encontrado.");
        }
    }
	
	
}
