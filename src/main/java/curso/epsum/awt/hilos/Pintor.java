package curso.epsum.awt.hilos;

import curso.epsum.awt.PrimeraVentana;
import curso.epsum.awt.bolas.Bola;

public class Pintor extends Thread {
	private PrimeraVentana primeraVentana;
	
	public Pintor(PrimeraVentana primeraVentana) {
		this.primeraVentana=primeraVentana;
	}
	
	@Override
	public void run() {
		while (true) {
			while (true) {
				try {
					Thread.sleep(5);
					getPrimeraVentana().getExterno().clearRect(0, 0, getPrimeraVentana().getWidth(),getPrimeraVentana().getHeight());
					for (Bola bola : getPrimeraVentana().getBolas()) {


						
						getPrimeraVentana().getExterno().fillOval(bola.getPosicionX(), bola.getPosicionY(), bola.getDimension(),
								bola.getDimension());
						
						
					}
					getPrimeraVentana().repaint();
				} catch (Exception e) {
					
				}
				
			}
			
			
		}
	}

	public PrimeraVentana getPrimeraVentana() {
		return primeraVentana;
	}

	public void setPrimeraVentana(PrimeraVentana primeraVentana) {
		this.primeraVentana = primeraVentana;
	}

}
