package epsum.curspo.musicos;

import org.springframework.stereotype.Component;

import epsum.curspo.instrumentos.Instrumento;

@Component
public class HombreOrquesta extends Musico {

	@Override
	public void tocar() {
		for (Instrumento	instrumento	  : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}
	}

}
