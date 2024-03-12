package curso.epsum.awt.hilos;

import curso.epsum.awt.PrimeraVentana;
import curso.epsum.awt.bolas.Bola;

public class BolaHilo extends Thread {
	
	private Bola bola;
	private PrimeraVentana primeraVentana;
	
	public BolaHilo(Bola bola, PrimeraVentana primeraVentana) {
		this.bola=bola;
		this.primeraVentana=primeraVentana;
	}
	
	@Override
	public void run() {
		while(true) {
			getBola().setPosicionX(getBola().getPosicionX()+getBola().getIncrementoX()*getBola().getSentidoX());
			getBola().setPosicionY(getBola().getPosicionY()+getBola().getIncrementoY()*getBola().getSentidoY());
			//getPrimeraVentana().getExterno() .clearRect(0, 0, getPrimeraVentana().getWidth(),getPrimeraVentana().getHeight());
			
			
			if(getBola().getPosicionX()<0 || getBola().getPosicionX()+getBola().getDimension()>getPrimeraVentana().getWidth())
				getBola().setSentidoX(getBola().getSentidoX()*-1);
			if(getBola().getPosicionY()<0 || getBola().getPosicionY()+getBola().getDimension()>getPrimeraVentana().getHeight())
				getBola().setSentidoY(getBola().getSentidoY()*-1);
			
			
		}
		
	}

	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
	}

	public PrimeraVentana getPrimeraVentana() {
		return primeraVentana;
	}

	public void setPrimeraVentana(PrimeraVentana primeraVentana) {
		this.primeraVentana = primeraVentana;
	}

}
