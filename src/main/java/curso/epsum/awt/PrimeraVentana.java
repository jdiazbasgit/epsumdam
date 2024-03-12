package curso.epsum.awt;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import curso.epsum.awt.bolas.Bola;
import curso.epsum.awt.hilos.BolaHilo;

public class PrimeraVentana extends Frame {
	
	private Graphics externo;
	private Image imagen;
	
	public PrimeraVentana() {
		this.setSize(1280,800);
		this.setLocation(50, 50);
		this.setBackground(Color.PINK);
		//ElQueSabeLoQueHayQueHacerConLaVentana pepe= new ElQueSabeLoQueHayQueHacerConLaVentana();
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		

	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
		if(getExterno()==null) {
			setImagen(createImage(this.getWidth(),this.getHeight()));
			setExterno(getImagen().getGraphics());
			for (int i = 0; i < 2; i++) {
				Bola bola = new Bola();
				bola.setPosicionX(i*10);
				bola.setPosicionY(i*10);
				bola.setSentidoX(1);
				bola.setSentidoY(1);
				bola.setIncrementoX(1);
				bola.setIncrementoY(1);
				bola.setDimension(50);
				BolaHilo bolaHilo = new BolaHilo(bola, this);
				bolaHilo.start();
				
			}
		}
		
		getExterno().clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(getImagen(), 0, 0, this);
		/*for (int i = 0; i < 1280; i++) {
			getExterno().clearRect(0, 0, 1280, 800);
			getExterno().fillOval(i, 50, 50, 50);
			g.drawImage(getImagen(),0,0,this);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/

		
	}

	public Graphics getExterno() {
		return externo;
	}

	public void setExterno(Graphics externo) {
		this.externo = externo;
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

}
