package curso.epsum.concierto.musicos.interfaces;

import curso.epsum.concierto.excepciones.SinSonidException;

public interface MusicoInterface {
	
	public void tocar() throws SinSonidException;

}
