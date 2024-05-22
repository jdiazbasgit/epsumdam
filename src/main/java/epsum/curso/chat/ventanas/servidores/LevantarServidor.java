package epsum.curso.chat.ventanas.servidores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import epsum.curso.chat.ventanas.configuration.ServidorConfiguration;
import lombok.Data;

@SpringBootApplication
@Data
@Import(ServidorConfiguration.class)
public class LevantarServidor implements CommandLineRunner {

	@Autowired
	private ServidorEscuchaRegistroServidor servidorEscuchaRegistroServidor;
	@Autowired
	private ServidorEscuchaBajaServidor servidorEscuchaBajaServidor;
	@Autowired
	private ServidorEscuchaMensajeServidor servidorEscuchaMensajeServidor;
	
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(LevantarServidor.class);
		builder.headless(false);
		builder.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		getServidorEscuchaRegistroServidor().start();
		getServidorEscuchaBajaServidor().start();
		getServidorEscuchaMensajeServidor().start();

	}

	

}
