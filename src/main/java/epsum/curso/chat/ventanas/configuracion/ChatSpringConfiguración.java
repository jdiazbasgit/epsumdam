package epsum.curso.chat.ventanas.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import epsum.curso.chat.ventanas.VentanaChat;
import epsum.curso.chat.ventanas.VerVentanaChat;
import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@Configuration
@Data

public class ChatSpringConfiguración {
	
	@Autowired
	private VentanaChat ventanaChat;

    

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