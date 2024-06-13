package curso.epsum.concierto.musicos.clases;

import curso.epsum.concierto.excepciones.SinSonidoException;

public class Solista extends Musico {

	@Override
	public void tocar() throws SinSonidoException {
		System.out.println(getInstrumento().sonar());
		
	}


}
