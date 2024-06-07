package epsum.curso.chatspring.configuracion;

import java.awt.Dialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import epsum.curso.chatspring.ventanas.DialogPrivado;
import epsum.curso.chatspring.ventanas.VentanaChat;
import epsum.curso.chatspring.ventanas.VerVentanaChat;
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

public class ChatSpringConfiguración {
	
	private DialogPrivado dialogPrivado;
	private ClienteChat clienteChat;
	
	@Autowired
	private VentanaChat ventanaChat;

	@Bean
	 ClienteEnvioBajaCliente clienteEnvioBajaCliente() {
		return new ClienteEnvioBajaCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_BAJA);
	}
	
	@Bean
	@Scope("prototype")
	 ClienteEnvioMensajeCliente clienteEnvioMensajeCliente() {
		return new ClienteEnvioMensajeCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE, getVentanaChat());
	}
	
	@Bean
	 ClienteEnvioMensajePrivado clienteEnvioMensajePrivado() {
		return new ClienteEnvioMensajePrivado(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_MENSAJE, getDialogPrivado());
	}
	
	@Bean
	 ClienteenvioPeticionPrivado clienteenvioPeticionPrivado() {
		return new ClienteenvioPeticionPrivado(clienteChat.getIp(), ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, getVentanaChat());
	}
	
	@Bean
	 ClienteEnvioRegistroCliente clienteEnvioRegistroCliente() {
		return new ClienteEnvioRegistroCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO, getVentanaChat());
	}

    @Bean
    ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente() {
		return new ServidorEscuchaRegistroCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO, ventanaChat);
	}
    @Bean
    ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente() {
    	return new ServidorEscuchaMensajeCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, ventanaChat);
    }
    @Bean
    ServidorEscuchaSolicitudPrivado escuchaSolicitudPrivado() {
    	return new ServidorEscuchaSolicitudPrivado(ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, ventanaChat);
    }
}
