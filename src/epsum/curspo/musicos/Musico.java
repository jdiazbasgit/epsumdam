package epsum.curspo.musicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epsum.curspo.instrumentos.Instrumento;

@Component
public abstract class Musico implements MusicoInterface {

	@Autowired
	private Instrumento instrumento;
	
	private List<Instrumento> instrumentos;
	
	@Override
	public abstract void tocar() ;

	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}

	public List<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

}
