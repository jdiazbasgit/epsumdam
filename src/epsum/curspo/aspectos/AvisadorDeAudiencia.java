package epsum.curspo.aspectos;

import java.sql.SQLSyntaxErrorException;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AvisadorDeAudiencia {

	@Pointcut("execution(@epsum.curspo.anotaciones.Vigilado * *.*(..))")
	public void sujetador() {}
	
	@Before("sujetador()")
	public void apagarMoviles() {
		System.err.println("Señores apaguen los moviles que va a empezar el concierto");
	}
	
	@After("sujetador()")
	public void encenderMoviels() {
		System.err.println("Señores ya pueden encender los moviles que el concierto ha terminado");
	}
	
}
