package epsum.curso.chatspring.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
	public ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente() {
		ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente= new  ServidorEscuchaRegistroCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO);
		return servidorEscuchaRegistroCliente;
	}

	@Bean
	public ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente() {
		ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente= new ServidorEscuchaMensajeCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE);
		return servidorEscuchaMensajeCliente;
	}

	@Bean
	public ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado() {
		ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrtivado= new ServidorEscuchaSolicitudPrivado(ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA);
		return servidorEscuchaSolicitudPrtivado;
	}
	
	@Bean
	public ClienteEnvioBajaCliente clienteEnvioBajaCliente() {
		ClienteEnvioBajaCliente clienteEnvioBajaCliente = new ClienteEnvioBajaCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_BAJA);
		return clienteEnvioBajaCliente;
	}
	
	@Bean
	@Scope("prototype")
	public ClienteEnvioMensajeCliente clienteEnvioMensajeCliente() {
		ClienteEnvioMensajeCliente clienteEnvioMensajeCliente = new ClienteEnvioMensajeCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE);
		return clienteEnvioMensajeCliente;
	}
	
	@Bean
	public ClienteEnvioRegistroCliente clienteEnvioRegistroCliente() {
		ClienteEnvioRegistroCliente clienteEnvioRegistroCliente = new ClienteEnvioRegistroCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO);
		return clienteEnvioRegistroCliente;
	}
	
	@Bean
	public ClienteenvioPeticionPrivado clienteenvioPeticionPrivado() {
		ClienteenvioPeticionPrivado clienteenvioPeticionPrivado = new ClienteenvioPeticionPrivado(null, ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA);
		return clienteenvioPeticionPrivado;
	}
}
