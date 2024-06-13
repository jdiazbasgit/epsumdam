package curso.epsum.concierto.musicos.interfaces;

import curso.epsum.concierto.excepciones.SinSonidoException;

public interface MusicoInterface {
	
	public void tocar() throws SinSonidoException;

}
