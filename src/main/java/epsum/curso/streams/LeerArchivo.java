package epsum.curso.streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LeerArchivo {

	public static void main(String[] args) {

		try(FileInputStream fileInputStream= new FileInputStream("prueba.txt");
			InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader= new BufferedReader(inputStreamReader)	) 
		{
			while(bufferedReader.ready()) {
				System.out.println(bufferedReader.readLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
