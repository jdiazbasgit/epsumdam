package epsum.curso.chat.ventanas.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;


import epsum.curso.chatspring.ventanas.VentanaChat;

@Configuration
public class Configuracion {

	@Autowired
	private VentanaChat ventanaChat;
		
	public int puertoEscuchaClienteRegistro() {
		int puerto = ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO;
		return puerto;
	}
	
	@Bean
	public ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente() {
		ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente= new  ServidorEscuchaRegistroCliente(puertoEscuchaClienteRegistro(),ventanaChat);
		return servidorEscuchaRegistroCliente;
	}

	@Bean
	public ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente() {
		ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente= new ServidorEscuchaMensajeCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, ventanaChat);
		return servidorEscuchaMensajeCliente;
	}

	@Bean
	public ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado() {
		ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrtivado= new ServidorEscuchaSolicitudPrivado(ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, ventanaChat);
		return servidorEscuchaSolicitudPrtivado;
	}

}