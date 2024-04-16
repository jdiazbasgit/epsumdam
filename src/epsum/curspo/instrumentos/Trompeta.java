package epsum.curspo.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tocameAMi")
public class Trompeta extends Instrumento {

	public Trompeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trompeta(String sonido) {
		super(sonido);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Value("tuuu, tuuu en anotaciones")
	public void setSonido(String sonido) {
		super.setSonido(sonido);
	}
}
