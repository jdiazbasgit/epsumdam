package epsum.curspo.instrumentos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Instrumento implements InstrumentoInterface {

	//@Value("pom, pom, pom con spring")
	private String sonido;
	
	public Instrumento() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Instrumento(String sonido) {
		super();
		this.sonido = sonido;
	}

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
