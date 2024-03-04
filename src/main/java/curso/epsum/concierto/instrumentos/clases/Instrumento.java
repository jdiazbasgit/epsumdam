package curso.epsum.concierto.instrumentos.clases;

import curso.epsum.concierto.instrumentos.interfaces.InstrumentoInterface;

public class Instrumento implements InstrumentoInterface,Comparable<Instrumento> {

	
	private String sonido;
	
	public Instrumento(String sonido) {
		this.sonido=sonido;
	}
	
	@Override
	public int compareTo(Instrumento otro) {
		// TODO Auto-generated method stub
		return this.getSonido().compareTo(otro.getSonido());
	}
	
	@Override
	public boolean equals(Object obj) {
		Instrumento otro=(Instrumento) obj;
		return this.getSonido().equals(otro.getSonido());
	}
	
	@Override
	public int hashCode() {
		
		return this.getSonido().hashCode()+1;
	}
	
	@Override
	public String sonar() {
		return getSonido();
	}

	public String getSonido() {
		return sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

	

	
}
