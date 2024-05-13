package epsum.curso.chatspring.ventanas.servidores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import epsum.curso.chatspring.configuracion.ConfiguracionVentana;
import lombok.Data;

@SpringBootApplication
@Data
@Import(ConfiguracionVentana.class)
public class LevantarServidor implements CommandLineRunner {
	@Autowired
	private ServidorEscuchaBajaServidor servidorEscuchaBajaServidor;
	@Autowired
	private ServidorEscuchaMensajeServidor servidorEscuchaMensajeServidor;
	@Autowired
	private ServidorEscuchaRegistroServidor servidorEscuchaRegistroServidor;
	
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(LevantarServidor.class);
		builder.headless(false);
		builder.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		servidorEscuchaRegistroServidor().start();
		servidorEscuchaBajaServidor().start();
		servidorEscuchaMensajeServidor().start();

	}


}
