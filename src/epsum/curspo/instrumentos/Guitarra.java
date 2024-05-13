package epsum.curspo.instrumentos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Scope("prototype")
public class Guitarra extends Instrumento {

	@Override
	@Value("tlan, tlqan tlan con anotaciones")
	public void setSonido(String sonido) {
		// TODO Auto-generated method stub
		super.setSonido(sonido);
	}
}
