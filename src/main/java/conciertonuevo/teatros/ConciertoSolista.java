package conciertonuevo.teatros;

import conciertonuevo.excepciones.SinSonidoException;
import conciertonuevo.instrumentos.Trompeta;
import conciertonuevo.musicos.Solista;

public class ConciertoSolista {

	public ConciertoSolista() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Trompeta trompeta= new Trompeta();
		trompeta.setSonido("tuuuuuuu");
		Solista solista= new Solista(trompeta);
		//solista.setInstrumento(trompeta);
		try {
			solista.tocar();
		} catch (SinSonidoException e) {
			
		}

	}

}
