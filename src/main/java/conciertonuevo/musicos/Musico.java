package conciertonuevo.musicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import conciertonuevo.excepciones.SinSonidoException;
import conciertonuevo.instrumentos.Instrumento;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public abstract class Musico implements MusicoInterface {

	
	private Instrumento instrumento;
	
	private List<Instrumento> instrumentos;
	public Musico() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void tocar() throws SinSonidoException ;

}
