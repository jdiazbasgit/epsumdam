package curso.epsum.awt;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ElQueSabeLoQueHayQueHacerConElRaton implements MouseListener {

	private PrimeraVentana primeraVentana;
	public ElQueSabeLoQueHayQueHacerConElRaton(PrimeraVentana primeraVentana) {
		this.primeraVentana=primeraVentana;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		getPrimeraVentana().crearbola(e.getX(),e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public PrimeraVentana getPrimeraVentana() {
		return primeraVentana;
	}
	public void setPrimeraVentana(PrimeraVentana primeraVentana) {
		this.primeraVentana = primeraVentana;
	}

	
}
