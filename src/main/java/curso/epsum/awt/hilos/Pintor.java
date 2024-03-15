package curso.epsum.awt.hilos;

import curso.epsum.awt.PrimeraVentana;

public class Pintor extends Thread {
	private PrimeraVentana primeraVentana;
	
	public Pintor(PrimeraVentana primeraVentana) {
		this.primeraVentana=primeraVentana;
	}
	
	@Override
	public void run() {
		while (true) {
			getPrimeraVentana().repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
