package excepciones.excepciones;

public class SinGasolinaException extends Exception {

	

	public SinGasolinaException(String message) {
		super(message);
	}
	
	public void echarGasolina(boolean gasolina) {
		System.out.println("HEMOS REPOSTADO");
		gasolina=true;
	}

}
