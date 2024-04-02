package epsum.curspo.musicos;

import epsum.curspo.instrumentos.Instrumento;

public class HombreOrquesta extends Musico {

	@Override
	public void tocar() {
		for (Instrumento	instrumento	  : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}
	}

}
