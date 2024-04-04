package epsum.curspo.teatros;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epsum.curspo.configuracion.Configuracion;
import epsum.curspo.musicos.Musico;
import epsum.curspo.musicos.Solista;

public class ConciertoSolistaSpring {

	public static void main(String[] args) {
		
		ApplicationContext armario= new AnnotationConfigApplicationContext(Configuracion.class);
		Solista pepe= (Solista) armario.getBean("solista");
		pepe.tocar();
	}

}
