package epsum.curspo.instrumentos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Instrumento implements InstrumentoInterface {

	private String sonido;
	
	@Override
	public String sonar() {
		
		return getSonido();
	}

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

}
