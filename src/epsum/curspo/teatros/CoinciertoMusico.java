package epsum.curspo.teatros;

import epsum.curspo.instrumentos.Instrumento;
import epsum.curspo.musicos.Musico;
import epsum.curspo.musicos.Solista;

public class CoinciertoMusico {

	public static void main(String[] args) {
		
		
		Instrumento tambor= new Instrumento();
		Solista solista = new Solista();
		tambor.setSonido("pom, pom pom");
		solista.setInstrumento(tambor);
		solista.tocar();

	}

}
