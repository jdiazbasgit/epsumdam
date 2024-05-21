package conciertonuevo.instrumentos;

import lombok.Data;

@Data
public class Instrumento implements InstrumentoInterface {
	private String sonido;

	public Instrumento() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sonar() {
		// TODO Auto-generated method stub
		return getSonido();
	}

}
