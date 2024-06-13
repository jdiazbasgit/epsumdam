package excepciones.clases;

import excepciones.excepciones.RuedaPinchadaException;
import excepciones.excepciones.SinBateriaException;
import excepciones.excepciones.SinGasolinaException;

public interface CocheInterface {

	public void salirDeViaje() throws SinGasolinaException,SinBateriaException,RuedaPinchadaException;
}
