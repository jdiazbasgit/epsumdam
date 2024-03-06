package epsum.curso.streams;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class EscribirTexto {

	public static void main(String[] args) {

		try (FileOutputStream fileOutputStream= new FileOutputStream("prueba.txt",true);
				PrintWriter printWriter= new PrintWriter(fileOutputStream))
		{
			
			printWriter.println("estoy escribiendo en un stream");
			printWriter.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
