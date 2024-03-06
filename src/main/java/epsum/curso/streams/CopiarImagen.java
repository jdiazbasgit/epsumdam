package epsum.curso.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopiarImagen {

	public static void main(String[] args) {
		try (FileInputStream fileInputStream= new FileInputStream("camion.png");
				FileOutputStream fileOutputStream= new FileOutputStream("copia de camion.png")){
			byte[] b= new byte[fileInputStream.available()];
			System.out.println(b);
			fileInputStream.read(b);
			fileOutputStream.write(b);
			fileOutputStream.flush();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
