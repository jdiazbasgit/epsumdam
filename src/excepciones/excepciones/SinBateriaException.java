package excepciones.excepciones;

public class SinBateriaException extends Exception {

	public SinBateriaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public void cambiarBateria(boolean bateria) {
		System.out.println("BATERIA CAMBIADA");
		bateria=true;
	}

}
