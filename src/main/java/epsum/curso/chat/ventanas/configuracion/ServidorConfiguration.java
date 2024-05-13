package epsum.curso.chat.ventanas.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.chat.ventanas.servidores.ServidorChat;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaBajaServidor;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaMensajeServidor;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaRegistroServidor;

@Configuration
public class ServidorConfiguration {

	
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
