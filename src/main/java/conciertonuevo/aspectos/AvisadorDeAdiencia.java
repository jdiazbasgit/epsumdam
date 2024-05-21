package conciertonuevo.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import conciertonuevo.excepciones.SinSonidoException;
import conciertonuevo.instrumentos.Instrumento;
import conciertonuevo.musicos.HombreOrquesta;
import conciertonuevo.musicos.Musico;
import conciertonuevo.musicos.Solista;

@Component
@Aspect
public class AvisadorDeAdiencia {
	
	@Pointcut("execution(@conciertonuevo.anotaciones.Vigilado * *.*(..))")
	public void sujetador() {};
	
	//@Before("sujetador()")
	public void apagarMoviles() {
		//System.out.println("SEÑORES APAGUEN LOS MOVILES");
	}
	
	//@After("sujetador()")
	public void encenderMoviles() {
		//System.out.println("SEÑORES ENCIENDAN LOS MOVILES");
	}
	
	@Around("sujetador()")
	public void hacerTodo(ProceedingJoinPoint joinPoint) {
		
		Musico musico= (Musico) joinPoint.getTarget();
		
		try {
			//before
			System.out.println("SEÑORES APAGUEN LOS MOVILES EN AROUND");
			joinPoint.proceed();
			//afterReturning
			System.out.println("plas, plas, plas, plas");
			
		} catch (Throwable e) {
			//afterThrowing
			System.out.println("SEÑORES SE HA ROTO EL INSTRUMENTO NO SE PREOCUPEN QUE VOY A ARREGLARLO");
			if(musico.getClass().isInstance(new HombreOrquesta())){
				HombreOrquesta hombreOrquesta= (HombreOrquesta) musico;
				for(Instrumento instrumento:hombreOrquesta.getInstrumentos()) {
					if(instrumento.getSonido().equals("nada")) {
						instrumento.setSonido("Sonido arreglado");
					}
				}
			}
			else
			{
				if(musico.getInstrumento().getSonido().equals("nada"))
					musico.getInstrumento().setSonido("sonido arreglado");
			}
			System.out.println("SEÑORES TODO ARREGLADO. CONTINUAMOS EL CONCIERTO");
			try {
				musico.tocar();
			} catch (SinSonidoException e1) {
				
			}
		}
		finally {
			//After
			System.out.println("SEÑORES ENCIENDAN LOS MOVILES EN AROUND");
		}
		
	}

}








