package conciertonuevo.teatros;

import java.util.ArrayList;

import conciertonuevo.excepciones.SinSonidoException;
import conciertonuevo.instrumentos.Guitarra;
import conciertonuevo.instrumentos.Tambor;
import conciertonuevo.instrumentos.Trompeta;
import conciertonuevo.musicos.HombreOrquesta;

public class ConciertoiHombreOrquesta {

	public ConciertoiHombreOrquesta() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Trompeta trompeta= new Trompeta();
		trompeta.setSonido("tuuuuuuu");
		Tambor tambor= new Tambor();
		tambor.setSonido("pommmmm");
		Guitarra guitarra= new Guitarra();
		guitarra.setSonido("tlannnnnn");
		
		HombreOrquesta hombreOrquesta= new HombreOrquesta();
		hombreOrquesta.setInstrumentos(new ArrayList<>());
		hombreOrquesta.getInstrumentos().add(trompeta);
		hombreOrquesta.getInstrumentos().add(guitarra);
		hombreOrquesta.getInstrumentos().add(tambor);
		try {
			hombreOrquesta.tocar();
		} catch (SinSonidoException e) {
			
		}

	}

}
