package pratica06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class cursoFileReader {
	public static void main(String[] args) throws FileNotFoundException {
		 File file = new File("/home/mikaelle/eclipse-workspace/pratica06/entrada.txt");
		 FileReader fr = new FileReader(file);
		 BufferedReader br = new BufferedReader(fr);
		 
		 try {
			 String line = br.readLine();
			 while(line != null) {
				 System.out.println(line + "-");
				 line = br.readLine();
			 }
			 
		 }
		 catch(IOException e) {
			 System.out.println("error: "+ e.getMessage());
		 }
		 finally {
			 try {
				 if(br !=null) {
					br.close();
				 }
				 if(fr !=null) {
					fr.close();
				 }
				 
			 }catch(IOException e) {
				 e.printStackTrace();
			}
		 }

	 }
}
