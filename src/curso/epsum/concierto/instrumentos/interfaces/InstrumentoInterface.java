package curso.epsum.concierto.instrumentos.interfaces;

import curso.epsum.concierto.excepciones.SinSonidException;

public interface InstrumentoInterface {
	
	public String sonar() throws SinSonidException;

}
