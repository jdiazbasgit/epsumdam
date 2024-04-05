package epsum.curspo.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tocameAMi")
@Scope("prototype")
public class Guitarra extends Instrumento {

	public Guitarra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guitarra(String sonido) {
		super(sonido);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Value("tlan, tlan en anotaciones")
	public void setSonido(String sonido) {
		// TODO Auto-generated method stub
		super.setSonido(sonido);
	}
}
