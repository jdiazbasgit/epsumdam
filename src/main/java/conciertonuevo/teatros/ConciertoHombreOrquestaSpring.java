package conciertonuevo.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import conciertonuevo.excepciones.SinSonidoException;
import conciertonuevo.instrumentos.Configuracion;
import conciertonuevo.musicos.HombreOrquesta;
import conciertonuevo.musicos.MusicoInterface;

public class ConciertoHombreOrquestaSpring {

	public ConciertoHombreOrquestaSpring() {
		
	}
	
	public static void main(String[] args) {
		ApplicationContext armario= new AnnotationConfigApplicationContext(Configuracion.class);
		MusicoInterface hombreOrquesta= (MusicoInterface) armario.getBean("felipe");
		try {
			hombreOrquesta.tocar();
		} catch (SinSonidoException e) {
			System.out.println("instrumento roto");
		}
	}

}
