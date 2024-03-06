package epsum.curso.streams;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import epsum.curso.streams.beans.Agenda;

public class EscribirObjeto {

	public static void main(String[] args) {
		
		try(FileOutputStream fileOutputStream= new FileOutputStream("pepe.agenda");
				ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream))
		{
			
			Agenda pepe= new Agenda();
			pepe.setNombre("pepe");
			pepe.setDireccion("Mi casa");
			pepe.setTelefono("64535243");
			objectOutputStream.writeObject(pepe);
			objectOutputStream.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
