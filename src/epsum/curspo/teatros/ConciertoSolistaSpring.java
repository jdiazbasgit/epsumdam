package epsum.curspo.teatros;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epsum.curspo.configuracion.Configuracion;
import epsum.curspo.musicos.HombreOrquesta;
import epsum.curspo.musicos.Musico;

public class ConciertoSolistaSpring {

	public static void main(String[] args) {
		try {
			PrintWriter ps= new PrintWriter(new FileOutputStream("pepe.txt"));
			ps.print("aa");
			ps.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}

		ApplicationContext armario= new AnnotationConfigApplicationContext(Configuracion.class);
		//ApplicationContext armario =new ClassPathXmlApplicationContext("spring.xml");
		Musico pepe= (Musico) armario.getBean("solista");
		System.out.println("toca el solista");
		pepe.tocar();
		pepe.getInstrumento().setSonido("sonido cambiado");
		System.out.println("vuelve a tocar el solista");
		pepe.tocar();
		HombreOrquesta hombreOrquesta= (HombreOrquesta) armario.getBean("hombreOrquesta");
		System.out.println("toca el hombre orquesta");
		hombreOrquesta.tocar();
	}

}
