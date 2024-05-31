package epsum.curso.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import epsum.curso.chat.ventanas.configuracion.ServidorConfiguration;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaBajaServidor;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaMensajeServidor;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaRegistroServidor;
import lombok.Data;

@SpringBootApplication
@Data
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
		getServidorEscuchaBajaServidor().start();
		getServidorEscuchaMensajeServidor().start();
		getServidorEscuchaRegistroServidor().start();

	}
	
	
	
}
