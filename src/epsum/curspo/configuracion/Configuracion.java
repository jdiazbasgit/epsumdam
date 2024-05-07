package epsum.curspo.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import epsum.curspo.instrumentos.Guitarra;
import epsum.curspo.musicos.Solista;

@Configuration
@ComponentScan("epsum.curspo")
public class Configuracion {

	/*@Bean
	public Guitarra guitarra() {
		Guitarra guitarra= new Guitarra();
		guitarra.setSonido("tlan, tlaqn, tlan en configuracion");
		return guitarra;
	}
	
	@Bean
	public Solista musico() {
		Solista solista= new Solista();
		solista.setInstrumento(guitarra());
		return solista;
	}*/
}
