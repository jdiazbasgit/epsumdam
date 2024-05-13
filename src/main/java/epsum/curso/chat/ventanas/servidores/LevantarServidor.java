package epsum.curso.chat.ventanas.servidores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import lombok.Data;

@SpringBootApplication
@Data
public class LevantarServidor implements CommandLineRunner {

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

	@Bean
	public ServidorEscuchaRegistroServidor servidorEscuchaRegistroServidor() {
		ServidorEscuchaRegistroServidor servidorEscuchaRegistroServidor = new ServidorEscuchaRegistroServidor(
				ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO);
		return servidorEscuchaRegistroServidor;
	}

	@Bean
	public ServidorEscuchaBajaServidor servidorEscuchaBajaServidor() {
		ServidorEscuchaBajaServidor servidorEscuchaBajaServidor = new ServidorEscuchaBajaServidor(
				ServidorChat.PUERTO_ESCUCHA_SERVIDOR_BAJA);
		return servidorEscuchaBajaServidor;
	}

	@Bean
	public ServidorEscuchaMensajeServidor servidorEscuchaMensajeServidor() {
		ServidorEscuchaMensajeServidor servidorEscuchaMensajeServidor = new ServidorEscuchaMensajeServidor(
				ServidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE);
		return servidorEscuchaMensajeServidor;
	}

}
