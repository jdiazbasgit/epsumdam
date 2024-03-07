package curso.epsum.concierto.teatros;

import curso.epsum.concierto.excepciones.SinSonidException;
import curso.epsum.concierto.instrumentos.clases.Instrumento;
import curso.epsum.concierto.musicos.clases.Solista;

public class ConciertoSolista {

	public static void main(String[] args) {
		Instrumento tambor= new Instrumento("nada");
		Solista federico= new Solista();
		federico.setInstrumento(tambor);
		try {
			federico.tocar();
		} catch (SinSonidException e) {
			e.devolverDinero();
		}
	}

}
