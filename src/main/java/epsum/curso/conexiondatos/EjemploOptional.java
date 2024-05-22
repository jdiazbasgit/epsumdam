package epsum.curso.conexiondatos;

import java.util.Optional;

public class EjemploOptional {

	public EjemploOptional() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String nombre=null;
		Optional optionalNombre=Optional.ofNullable(nombre);
		System.out.println(optionalNombre.isPresent());
	}

}
