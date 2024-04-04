package epsum.curspo.musicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import epsum.curspo.instrumentos.Instrumento;

@Component
public class Solista extends Musico {

	@Override
	public void tocar() {
		System.out.println(getInstrumento().sonar());
	}
	
	@Override
	@Autowired
	@Qualifier("guitarra")
	public void setInstrumento(Instrumento instrumento) {
		super.setInstrumento(instrumento);
	}

}
