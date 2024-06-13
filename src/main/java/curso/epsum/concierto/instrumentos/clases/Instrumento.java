package curso.epsum.concierto.instrumentos.clases;

import curso.epsum.concierto.excepciones.SinSonidoException;
import curso.epsum.concierto.instrumentos.interfaces.InstrumentoInterface;

public class Instrumento implements InstrumentoInterface{

	
	private String sonido;
	
	public Instrumento(String sonido) {
		this.sonido=sonido;
	}
	@Override
	public String sonar() throws SinSonidoException {
		if(getSonido().equals(""))
			throw new SinSonidoException();
		return getSonido();
	}
	
	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}


	

	

	
}
