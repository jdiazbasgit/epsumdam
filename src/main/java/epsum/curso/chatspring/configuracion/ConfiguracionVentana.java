package epsum.curso.chatspring.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.chatspring.ventanas.DialogPrivado;
import epsum.curso.chatspring.ventanas.VentanaChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioBajaCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioMensajeCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioMensajePrivado;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioRegistroCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteenvioPeticionPrivado;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@Configuration
@Data
public class ConfiguracionVentana {

	private int puerto = 9000;
	private VentanaChat ventanaChat;
	private DialogPrivado dialogPrivado;
	private ClienteChat clienteChat;
	
	@Bean
	public VentanaChat getVentanaChat() {
		return new VentanaChat();
	}
	
	@Bean
	public ClienteEnvioBajaCliente clienteEnvioBajaCliente() {
		return new ClienteEnvioBajaCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_BAJA);
	}
	
	@Bean
	public ClienteEnvioMensajeCliente clienteEnvioMensajeCliente() {
		return new ClienteEnvioMensajeCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE, ventanaChat);
	}
	
	@Bean
	public ClienteEnvioMensajePrivado clienteEnvioMensajePrivado() {
		return new ClienteEnvioMensajePrivado(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE, dialogPrivado);
	}
	
	@Bean
	public ClienteenvioPeticionPrivado clienteenvioPeticionPrivado() {
		return new ClienteenvioPeticionPrivado(clienteChat.getIp(), ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, ventanaChat);
	}
	
	@Bean
	public ClienteEnvioRegistroCliente clienteEnvioRegistroCliente() {
		return new ClienteEnvioRegistroCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO, ventanaChat);
	}
	
	@Bean
	public ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente() {
		ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente = new ServidorEscuchaMensajeCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, ventanaChat);
		return servidorEscuchaMensajeCliente;
	}
	
	@Bean
	public ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente() {
		ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente = new ServidorEscuchaRegistroCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO, ventanaChat);
		return servidorEscuchaRegistroCliente;
	}
	
	@Bean
	public ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado() {
		ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado = new ServidorEscuchaSolicitudPrivado(ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, ventanaChat);
		return servidorEscuchaSolicitudPrivado;
	}
}
