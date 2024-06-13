package excepciones.excepciones;

public class RuedaPinchadaException extends Exception {

	public RuedaPinchadaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public void cambiarRueda(boolean rueda) {
		System.out.println("RUEDA CAMBIADA");
		rueda=true;
	}

}
