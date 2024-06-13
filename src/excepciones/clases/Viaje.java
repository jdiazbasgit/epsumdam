package excepciones.clases;

import excepciones.excepciones.RuedaPinchadaException;
import excepciones.excepciones.SinBateriaException;
import excepciones.excepciones.SinGasolinaException;

public class Viaje {

	public static final String INTENTAR = "vamos a intentar arrancar de nuevo";

	public static void main(String[] args) {
		Coche coche = new Coche();
		coche.setBateria(false);
		coche.setGasolina(true);
		coche.setRueda(false);
		while (!coche.isRueda() || !coche.isBateria() || !coche.isGasolina()) {
			try {
				coche.salirDeViaje();
			} /*
				 * catch (Exception e) {
				 * System.out.println("llamamos a la grua que lo arregle");
				 * coche.setBateria(true); coche.setGasolina(true); coche.setRueda(true); }
				 */

			catch (SinGasolinaException e) {
				System.out.println(e.getMessage());
				e.echarGasolina(coche.isGasolina());
				System.out.println(Viaje.INTENTAR);
				coche.setGasolina(true);
			} catch (SinBateriaException e) {
				System.out.println(e.getMessage());
				e.cambiarBateria(coche.isBateria());
				System.out.println(Viaje.INTENTAR);
				coche.setBateria(true);
			} catch (RuedaPinchadaException e) {
				System.out.println(e.getMessage());
				e.cambiarRueda(coche.isRueda());
				System.out.println(Viaje.INTENTAR);
				coche.setRueda(true);
			}
		}
		System.out.println(coche.arrancamos());

	}

}
