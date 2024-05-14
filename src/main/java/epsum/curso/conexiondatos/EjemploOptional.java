package epsum.curso.conexiondatos;

import java.util.Optional;

public class EjemploOptional {

	public EjemploOptional() {
		// TODO Auto-generated constructor stub
	}

	public static void main1(String[] args) {
		String nombre=null;
		Optional optionalNombre=Optional.of(nombre);
		System.out.println(optionalNombre.isEmpty());
	}

}
