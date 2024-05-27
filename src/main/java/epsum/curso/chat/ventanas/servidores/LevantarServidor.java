package epsum.curso.chat.ventanas.servidores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

<<<<<<< HEAD
import epsum.curso.chat.ventanas.configuracion.ServidorConfiguration;
=======
import epsum.curso.chat.ventanas.configuration.ServidorConfiguration;
>>>>>>> refs/remotes/origin/chat-rodrigo
import lombok.Data;

@SpringBootApplication
@Data
@Import(ServidorConfiguration.class)
public class LevantarServidor implements CommandLineRunner {
<<<<<<< HEAD
	@Autowired
	private ServidorEscuchaBajaServidor servidorEscuchaBajaServidor;
	@Autowired
	private ServidorEscuchaMensajeServidor servidorEscuchaMensajeServidor;
	@Autowired
	private ServidorEscuchaRegistroServidor servidorEscuchaRegistroServidor;
=======

	@Autowired
	private ServidorEscuchaRegistroServidor servidorEscuchaRegistroServidor;
	@Autowired
	private ServidorEscuchaBajaServidor servidorEscuchaBajaServidor;
	@Autowired
	private ServidorEscuchaMensajeServidor servidorEscuchaMensajeServidor;
	
>>>>>>> refs/remotes/origin/chat-rodrigo
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(LevantarServidor.class);
		builder.headless(false);
		builder.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
<<<<<<< HEAD
		getServidorEscuchaBajaServidor().start();
		getServidorEscuchaMensajeServidor().start();
		getServidorEscuchaRegistroServidor().start();
=======
		getServidorEscuchaRegistroServidor().start();
		getServidorEscuchaBajaServidor().start();
		getServidorEscuchaMensajeServidor().start();
>>>>>>> refs/remotes/origin/chat-rodrigo

	}

	
<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/chat-rodrigo
}
