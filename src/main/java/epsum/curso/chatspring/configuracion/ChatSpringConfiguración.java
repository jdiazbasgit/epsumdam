package epsum.curso.chatspring.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.chatspring.ventanas.VentanaChat;
import epsum.curso.chatspring.ventanas.VerVentanaChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@Configuration
@Data
public class ChatSpringConfiguración {
	
	@Autowired
	private VentanaChat ventanaChat;
	
	@Bean
	public VerVentanaChat getverVentanaChat() {
		return new VerVentanaChat();
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
