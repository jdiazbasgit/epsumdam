package conciertonuevo.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Qualifier("tocameami")
public class Guitarra extends Instrumento {

	public Guitarra() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	@Value("nada")
	public void setSonido(String sonido) {
		// TODO Auto-generated method stub
		super.setSonido(sonido);
	}

}
