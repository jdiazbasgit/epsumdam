package curso.epsum.awt.hilos;

import java.awt.geom.Rectangle2D;

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
			try {
				for (Bola bola : getPrimeraVentana().getBolas()) {
					if (!bola.equals(getBola())) {
						Rectangle2D rectangleYo = new Rectangle2D.Double(getBola().getPosicionX(),
								getBola().getPosicionY(), getBola().getDimension(), getBola().getDimension());
						Rectangle2D rectangleOtro = new Rectangle2D.Double(bola.getPosicionX(), bola.getPosicionY(),
								bola.getDimension(), bola.getDimension());
						if (rectangleYo.intersects(rectangleOtro)) {
							getBola().setSentidoX(getBola().getSentidoX() * -1);
							getBola().setSentidoY(getBola().getSentidoY() * -1);
							bola.setSentidoY(bola.getSentidoY() * -1);
							bola.setImpactos(bola.getImpactos()+1);
							getBola().setImpactos(getBola().getImpactos()+1);
						} 
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(getBola().getImpactos()>100)
			{
				getPrimeraVentana().getBolas().remove(getBola());
				break;
			}
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
