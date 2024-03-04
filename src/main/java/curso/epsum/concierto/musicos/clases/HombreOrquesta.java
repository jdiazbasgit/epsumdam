package curso.epsum.concierto.musicos.clases;

import curso.epsum.concierto.instrumentos.clases.Instrumento;

public class HombreOrquesta extends Musico {

	@Override
	public void tocar() {
		
		/*for (int i = 0; i < getInstrumentos().length; i++) {
			System.out.println(getInstrumentos()[i].sonar());
		}*/
		
		for (Instrumento instrumento : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}

	}

}
