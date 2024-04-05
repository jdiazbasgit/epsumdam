package epsum.curspo.instrumentos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Tambor extends Instrumento {

	@Override
	@Value("pom, pom en anotaciones")
	public void setSonido(String sonido) {
		super.setSonido(sonido);
	}

	public Tambor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tambor(String sonido) {
		super(sonido);
		// TODO Auto-generated constructor stub
	}
}
