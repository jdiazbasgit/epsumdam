package conciertonuevo.musicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import conciertonuevo.anotaciones.Vigilado;
import conciertonuevo.excepciones.SinSonidoException;
import conciertonuevo.instrumentos.Instrumento;
import lombok.AllArgsConstructor;
import lombok.Data;



public class Solista extends Musico {

	public Solista(Instrumento instrumento) {
		setInstrumento(instrumento);
	}

	@Override
	@Vigilado
	public void tocar() throws SinSonidoException  {
		if(getInstrumento().getSonido().equals("nada"))
			throw new SinSonidoException();
		System.out.println(getInstrumento().sonar());

	}
	
	@Override
	
	public void setInstrumento(Instrumento instrumento) {
		// TODO Auto-generated method stub
		super.setInstrumento(instrumento);
	}

}











