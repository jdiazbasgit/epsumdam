package epsum.curspo.teatros;

import epsum.curspo.instrumentos.Instrumento;
import epsum.curspo.musicos.Musico;
import epsum.curspo.musicos.Solista;

public class CoinciertoMusico {

	public static void main(String[] args) {
		
		Solista solista = new Solista();
		Instrumento tambor= new Instrumento();
		tambor.setSonido("pom, pom pom");
		solista.setInstrumento(tambor);
		solista.tocar();

	}

}
