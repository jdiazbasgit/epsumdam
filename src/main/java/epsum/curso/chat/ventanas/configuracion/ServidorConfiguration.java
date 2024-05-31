package epsum.curso.chat.ventanas.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioMensajeServidor;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioRegistroServidor;
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
	
	@Bean
	@Scope("prototype")
	public ClienteEnvioRegistroServidor clienteEnvioRegistroServidor() {
		
		return new ClienteEnvioRegistroServidor(null,ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO, null);
	}
	
	
	@Bean
	@Scope("prototype")
	public ClienteEnvioMensajeServidor clienteEnvioMensajeServidor() {
		return new ClienteEnvioMensajeServidor(null, ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, null);
	}

}
