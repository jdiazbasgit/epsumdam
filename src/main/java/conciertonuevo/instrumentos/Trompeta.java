package conciertonuevo.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tocameami")
public class Trompeta extends Instrumento {

	public Trompeta() {
		// TODO Auto-generated constructor stub
	}
	@Override
	@Value("tuuuuu")
	public void setSonido(String sonido) {
		// TODO Auto-generated method stub
		super.setSonido(sonido);
	}
}
