package epsum.curso.streams;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import epsum.curso.streams.beans.Agenda;

public class LeerObjeto {

	public static void main(String[] args) {

		try (FileInputStream fileInputStream= new FileInputStream("pepe.agenda");
			ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream)	)
		{
			Agenda pepe= (Agenda) objectInputStream.readObject();
			System.out.println(pepe.getNombre());
			System.out.println(pepe.getDireccion());
			System.out.println(pepe.getTelefono());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
