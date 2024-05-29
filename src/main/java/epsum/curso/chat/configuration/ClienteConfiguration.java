package epsum.curso.chat.configuration;

import java.io.PrintWriter;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import epsum.curso.chat.ventanas.VentanaChat;
import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioBajaCliente;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioMensajeCliente;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioRegistroCliente;
import epsum.curso.chat.ventanas.servidores.ServidorChat;
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
	
	@Bean
	@Scope("prototype")
	public ClienteEnvioMensajeCliente clienteEnvioMensajeCliente() {
		return new ClienteEnvioMensajeCliente(ClienteChat.SERVIDOR,ServidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE, ventanaChat);
		
	}
	@Bean
	@Scope("prototype")
	ClienteEnvioRegistroCliente clienteEnvioRegistroCliente() {
		return new ClienteEnvioRegistroCliente(ClienteChat.SERVIDOR,ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO, ventanaChat);
	}
	@Bean
	@Scope("prototype")
	ClienteEnvioBajaCliente clienteEnvioBajaCliente() {
		return new ClienteEnvioBajaCliente(null, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_BAJA);
	}
}
