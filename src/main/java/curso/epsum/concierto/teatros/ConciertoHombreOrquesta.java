package curso.epsum.concierto.teatros;

import java.util.HashSet;

import curso.epsum.concierto.instrumentos.clases.Instrumento;
import curso.epsum.concierto.musicos.clases.HombreOrquesta;

public class ConciertoHombreOrquesta {

	public static void main(String[] args) {

		Instrumento tambor= new Instrumento("pom, pom, pom");
		Instrumento trompeta= new Instrumento("tuuuu, tuuuu, tuuu");
		Instrumento guitarra= new Instrumento("tlan, tlan, tlan");
		
		HombreOrquesta andres= new HombreOrquesta();
		//Instrumento[] instrumentos= {tambor,trompeta,guitarra};
		andres.setInstrumentos(new HashSet<Instrumento>());
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		andres.getInstrumentos().add(trompeta);
		andres.getInstrumentos().add(guitarra);
		andres.getInstrumentos().add(tambor);
		
		andres.tocar();
	}

}
