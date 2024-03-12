package curso.epsum.awt;

import curso.epsum.awt.hilos.Pintor;

public class VerPrimeraVentana {

	public static void main(String[] args) {
		
		PrimeraVentana primeraVentana=new PrimeraVentana();
		primeraVentana.setVisible(true);
		Pintor pintor= new Pintor(primeraVentana);
		pintor.start();
	}

}
