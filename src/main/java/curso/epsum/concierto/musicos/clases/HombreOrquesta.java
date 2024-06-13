package curso.epsum.concierto.musicos.clases;

import curso.epsum.concierto.excepciones.SinSonidoException;
import curso.epsum.concierto.instrumentos.clases.Instrumento;

public class HombreOrquesta extends Musico {

	@Override
	public void tocar() throws SinSonidoException {
		
		/*for (int i = 0; i < getInstrumentos().length; i++) {
			System.out.println(getInstrumentos()[i].sonar());
		}*/
		
		for (Instrumento instrumento : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}
		
		/*getInstrumentos().stream().forEach(i->{
			System.out.println(i.sonar());
		});*/

	}

}
