package epsum.curso.chat.configuration;

import java.io.PrintWriter;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.chat.ventanas.VentanaChat;
import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@Configuration
@Data
public class ClienteConfiguration {
	@Autowired
	private VentanaChat ventanaChat;

	@Bean
	public ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente() {
		ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente = new ServidorEscuchaRegistroCliente(
				ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO, getVentanaChat());
		return servidorEscuchaRegistroCliente;

	}

	@Bean
	public ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente() {
		ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente = new ServidorEscuchaMensajeCliente(
				ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, getVentanaChat());
		return servidorEscuchaMensajeCliente;

	}

	@Bean
	public ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado() {
		ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado = new ServidorEscuchaSolicitudPrivado(
				ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, getVentanaChat());
		return servidorEscuchaSolicitudPrivado;

	}

}
