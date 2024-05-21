package conciertonuevo.instrumentos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Tambor extends Instrumento {

	public Tambor() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	@Value("pom en spring")
	public void setSonido(String sonido) {
		// TODO Auto-generated method stub
		super.setSonido(sonido);
	}

}
