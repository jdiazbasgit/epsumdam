package curso.epsum.awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import curso.epsum.awt.bolas.Bola;
import curso.epsum.awt.hilos.BolaHilo;

public class PrimeraVentana extends Frame {

	private Graphics externo;
	private Image imagen;
	private  List<Bola> bolas;

	public PrimeraVentana() {
		this.setSize(1280, 800);
		this.setLocation(50, 50);
		this.setBackground(Color.PINK);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		setBolas(new ArrayList<>());
		this.addMouseListener(new ElQueSabeLoQueHayQueHacerConElRaton(this));
	}

	public void crearbola(int x, int y) {
		Bola bola = new Bola();
		bola.setPosicionX(x);
		bola.setPosicionY(y);
		bola.setSentidoX(calculaSentido());
		bola.setSentidoY(calculaSentido());
		bola.setIncrementoX(calculaIncremento());
		bola.setIncrementoY(calculaIncremento());
		bola.setDimension(50);
		BolaHilo bolaHilo = new BolaHilo(bola, this);
		bolaHilo.start();
		try {
			getBolas().add(bola);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	private int calculaSentido() {
		int valorAleatorio=(int)(Math.random()*10);
		return (valorAleatorio%2==0?1:-1);
	}

	private int calculaIncremento() {
		int valorAleatorio=(int)(Math.random()*10);
		return (valorAleatorio%2==0?1:2);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		if (getExterno() == null) {
			setImagen(createImage(this.getWidth(), this.getHeight()));
			setExterno(getImagen().getGraphics());
		}
		g.drawImage(getImagen(), 0, 0, this);

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

	public synchronized List<Bola> getBolas() {
		return bolas;
	}

	public void setBolas(List<Bola> bolas) {
		this.bolas = bolas;
	}

}
