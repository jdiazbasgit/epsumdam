package conciertonuevo.musicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import conciertonuevo.anotaciones.Vigilado;
import conciertonuevo.excepciones.SinSonidoException;
import conciertonuevo.instrumentos.Instrumento;

@Component("felipe")
public class HombreOrquesta extends Musico {

	public HombreOrquesta() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Vigilado
	public void tocar() throws SinSonidoException {
		for (Instrumento instrumento:getInstrumentos()) {
			if(instrumento.getSonido().equals("nada"))
				throw new SinSonidoException();
			System.out.println(instrumento.getSonido());
		}

	}

	@Override
	@Autowired
	@Qualifier("tocameami")
	public void setInstrumentos(List<Instrumento> instrumentos) {
		// TODO Auto-generated method stub
		super.setInstrumentos(instrumentos);
	}

}
