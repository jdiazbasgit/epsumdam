package curso.epsum.concierto.teatros;

import java.util.ArrayList;

import curso.epsum.concierto.excepciones.SinSonidoException;
import curso.epsum.concierto.instrumentos.clases.Guitarra;
import curso.epsum.concierto.instrumentos.clases.Instrumento;
import curso.epsum.concierto.instrumentos.clases.Tambor;
import curso.epsum.concierto.instrumentos.clases.Trompeta;
import curso.epsum.concierto.musicos.clases.HombreOrquesta;

public class ConciertoHombreOrquesta {

	public static void main(String[] args) {

		Tambor tambor= new Tambor("pom, pom, pom");
		Trompeta trompeta= new Trompeta("tuuuu, tuuuu, tuuu");
		Guitarra guitarra= new Guitarra("tlan, tlan, tlan");
		
		HombreOrquesta andres= new HombreOrquesta();
		//Instrumento[] instrumentos= {tambor,trompeta,guitarra};
		andres.setInstrumentos(new ArrayList<>());
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		
		try {
			andres.tocar();
		} catch (SinSonidoException e) {
			System.out.println("señores se ha roto uno de los instrumentos");
		}
	}

}
