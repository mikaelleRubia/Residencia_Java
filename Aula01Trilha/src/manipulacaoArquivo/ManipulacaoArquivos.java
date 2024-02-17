package manipulacaoArquivo;

import java.io.File;

public class ManipulacaoArquivos extends ArquivoNaoEncontradoException {


    public static void manipularArquivo(String nomeDoArquivo) {
        File arquivo = new File(nomeDoArquivo);

        if (!arquivo.exists()) {
        	ArquivoNaoEncontradoException();
        }else {
        	System.out.println("Caminho absoluto do arquivo: " + arquivo.getAbsolutePath());
        	
        }
//        System.out.println("Caminho absoluto do arquivo: " + arquivo.getAbsolutePath());

    }
}


