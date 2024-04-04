package epsum.curspo.teatros;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import epsum.curspo.configuracion.Configuracion;
import epsum.curspo.musicos.HombreOrquesta;
import epsum.curspo.musicos.MusicoInterface;
import epsum.curspo.musicos.Solista;

public class ConciertoSolistaHombreOrquesta {

	public static void main(String[] args) {
		
		ApplicationContext armario= new AnnotationConfigApplicationContext(Configuracion.class);
		MusicoInterface pepe=(MusicoInterface) armario.getBean("solista");
		pepe.tocar();
		//pepe.getInstrumento().setSonido("sonido cambiado");
		//System.out.println("vuelve a tocar el solista");
		//pepe.tocar();		
		MusicoInterface federico= (MusicoInterface) armario.getBean("hombreOrquesta");
		federico.tocar();

	}

}
