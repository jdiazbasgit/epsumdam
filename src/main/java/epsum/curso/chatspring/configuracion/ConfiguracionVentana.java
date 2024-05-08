package epsum.curso.chatspring.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
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
import lombok.Data;

@Configuration
@Data

public class ConfiguracionVentana {

	private int puerto = 9000;
	
	@Autowired
	private VentanaChat ventanaChat;
	@Autowired
	private ClienteChat clienteChat;
	@Autowired
	private DialogPrivado dialogPrivado;
	@Autowired
	private ServidorChat servidorChat;
	
	@Bean
	public VentanaChat getVentanaChat() {
		return new VentanaChat();
	}
	
	@Bean
	public ClienteEnvioBajaCliente getClienteEnvioBajaCliente() {
		return new ClienteEnvioBajaCliente(clienteChat.SERVIDOR, servidorChat.PUERTO_ESCUCHA_SERVIDOR_BAJA);
	}
	
	@Bean
	public ClienteEnvioMensajeCliente getClienteEnvioMensajeCliente() {
		return new ClienteEnvioMensajeCliente(clienteChat.SERVIDOR, servidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE, ventanaChat);
	}
	
	@Bean
	public ClienteEnvioMensajePrivado getClienteEnvioMensajePrivado() {
		return new ClienteEnvioMensajePrivado(clienteChat.SERVIDOR, servidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE, dialogPrivado);
	}
	
	@Bean
	public ClienteenvioPeticionPrivado getClienteenvioPeticionPrivado() {
		return new ClienteenvioPeticionPrivado(clienteChat.getIp(), clienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, ventanaChat);
	}
	
	@Bean
	public ClienteEnvioRegistroCliente getClienteEnvioRegistroCliente() {
		return new ClienteEnvioRegistroCliente(clienteChat.SERVIDOR, servidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO, ventanaChat);
	}
	
	
}
