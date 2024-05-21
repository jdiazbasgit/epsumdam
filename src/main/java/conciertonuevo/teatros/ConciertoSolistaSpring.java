package conciertonuevo.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import conciertonuevo.excepciones.SinSonidoException;
import conciertonuevo.instrumentos.Configuracion;
import conciertonuevo.musicos.MusicoInterface;
import conciertonuevo.musicos.Solista;

public class ConciertoSolistaSpring {

	public static void main(String[] args) {
		ApplicationContext armario= new AnnotationConfigApplicationContext(Configuracion.class);
		MusicoInterface solista= (MusicoInterface) armario.getBean("solista");
		try {
			solista.tocar();
		} catch (SinSonidoException e) {
			System.out.println("instrumento roto");
		}

	}

}
