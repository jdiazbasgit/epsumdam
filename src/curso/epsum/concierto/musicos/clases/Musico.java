package curso.epsum.concierto.musicos.clases;

import java.util.List;
import java.util.Set;

import curso.epsum.concierto.instrumentos.clases.Instrumento;
import curso.epsum.concierto.musicos.interfaces.MusicoInterface;

public abstract class Musico implements MusicoInterface {

	
	private Instrumento instrumento;
	private List<Instrumento> instrumentos;
	
	@Override
	public abstract void tocar();

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
