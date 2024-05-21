package conciertonuevo.instrumentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import conciertonuevo.musicos.Solista;
import lombok.Data;

@Configuration
@ComponentScan("conciertoNuevo")
@EnableAspectJAutoProxy
@Data
public class Configuracion {

	@Autowired
	private Guitarra guitarra;
	
	@Bean
	public Solista solista() {
		return new Solista(getGuitarra());
	}

}
