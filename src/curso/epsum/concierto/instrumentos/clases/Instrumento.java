package curso.epsum.concierto.instrumentos.clases;

import curso.epsum.concierto.excepciones.SinSonidException;
import curso.epsum.concierto.instrumentos.interfaces.InstrumentoInterface;

public class Instrumento implements InstrumentoInterface {

	
	private String sonido;
	
	public Instrumento(String sonido) {
		this.sonido=sonido;
	}
	
	@Override
	public String sonar() throws SinSonidException {
		if(getSonido().equals("nada"))
			throw new SinSonidException();
		return getSonido();
	}

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

	
}
