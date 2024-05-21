package conciertonuevo.musicos;

import conciertonuevo.excepciones.SinSonidoException;

public interface MusicoInterface {
	public void tocar() throws SinSonidoException;
}
