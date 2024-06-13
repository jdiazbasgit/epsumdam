package excepciones.clases;

import excepciones.excepciones.RuedaPinchadaException;
import excepciones.excepciones.SinBateriaException;
import excepciones.excepciones.SinGasolinaException;

public class Coche implements CocheInterface {

	private boolean bateria,rueda,gasolina;
	@Override
	public void salirDeViaje() throws SinBateriaException, SinGasolinaException, RuedaPinchadaException {
		
		if(!isBateria())
			throw new SinBateriaException("NO TIENES BATERIA");
		if(!isGasolina())
			throw new SinGasolinaException("NO TIENES GASOLINA");
		if(!isRueda())
			throw new RuedaPinchadaException("LA RUEDA ESTA PINCHADA");
		
		
	}

	public String arrancamos() {
		return "VAMONOS A LA PLAYA";
	}
	public boolean isBateria() {
		return bateria;
	}
	public void setBateria(boolean bateria) {
		this.bateria = bateria;
	}
	public boolean isRueda() {
		return rueda;
	}
	public void setRueda(boolean rueda) {
		this.rueda = rueda;
	}
	public boolean isGasolina() {
		return gasolina;
	}
	public void setGasolina(boolean gasolina) {
		this.gasolina = gasolina;
	}
	

}
