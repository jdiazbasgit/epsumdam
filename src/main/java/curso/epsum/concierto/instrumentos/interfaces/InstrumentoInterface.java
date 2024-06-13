package curso.epsum.concierto.instrumentos.interfaces;

import curso.epsum.concierto.excepciones.SinSonidoException;

public interface InstrumentoInterface {
	
	public String sonar() throws SinSonidoException;

}
