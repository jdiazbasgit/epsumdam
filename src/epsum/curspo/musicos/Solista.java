package epsum.curspo.musicos;

import org.springframework.stereotype.Component;

import epsum.curspo.instrumentos.Instrumento;

@Component
public class Solista extends Musico {

	
	
	@Override
	public void tocar() {
		System.out.println(getInstrumento().sonar());
	}

}
