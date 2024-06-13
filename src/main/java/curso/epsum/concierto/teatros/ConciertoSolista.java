package curso.epsum.concierto.teatros;

import curso.epsum.concierto.excepciones.SinSonidoException;
import curso.epsum.concierto.instrumentos.clases.Tambor;
import curso.epsum.concierto.musicos.clases.Solista;

public class ConciertoSolista {

	public static void main(String[] args) {
		Tambor tambor= new Tambor("pom, pom, pom");
		Solista federico= new Solista();
		federico.setInstrumento(tambor);
		try {
			federico.tocar();
		} catch (SinSonidoException e) {
			System.out.println("señores se ha roto el instrumento");
		}
	}

}
