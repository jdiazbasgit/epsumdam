package epsum.curspo.musicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import epsum.curspo.anotaciones.Vigilado;
import epsum.curspo.instrumentos.Instrumento;

@Component
public class HombreOrquesta extends Musico {

	public HombreOrquesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	@Vigilado
	public void tocar() {
		for (Instrumento	instrumento	  : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}
	}
	
	@Override
	@Autowired
	//@Qualifier("tocameAMi")
	public void setInstrumentos(List<Instrumento> instrumentos) {
		super.setInstrumentos(instrumentos);
	}

}
