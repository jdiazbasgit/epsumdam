package curso.epsum.concierto.musicos.clases;

import curso.epsum.concierto.excepciones.SinSonidException;

public class Solista extends Musico {

	@Override
	public void tocar() throws SinSonidException {
		System.out.println(getInstrumento().sonar());
		
	}


}
