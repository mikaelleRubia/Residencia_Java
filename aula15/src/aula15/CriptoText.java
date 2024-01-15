package aula15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CriptoText {
	public static void process02(String file1, String file2, String senha) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		FileOutputStream saida = new FileOutputStream(file2);
		FileInputStream entrada = new FileInputStream(file1);
		
		try {
			boolean eof = false; int count = 0, contSenha =0;
			while (!eof) {
                int input = entrada.read();
                if(contSenha >= senha.length()) {
                	contSenha =0;
                	
                }
                if (input != -1) {
                    byte byteCriptografado = (byte) (input ^ senha.charAt(contSenha));
                    saida.write(byteCriptografado);
                    count++;
                } else
                    eof = true;
            }
		entrada.close();
		System.out.println("\nBytes lidos: " + count);
		
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
			}
		}
}
