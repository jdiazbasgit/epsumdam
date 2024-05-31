package epsum.curso.chat.ventanas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.servidores.ServidorChat;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@SpringBootApplication
@Data
public class VerVentanaChat  implements CommandLineRunner {
	@Autowired
	private VentanaChat ventanaChat;
	public static void main1(String[] args) {
		
		
<<<<<<< HEAD
=======
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(VerVentanaChat.class);
		builder.headless(false);
		builder.run(args);
>>>>>>> 6b13729fca9af6439953172a24babb0f632f2741
		
		
	}

	@Override
	public void run(String... args) throws Exception {

		
		servidorEscuchaMensajeCliente().start();
		servidorEscuchaRegistroCliente().start();
		servidorEscuchaSolicitudPrivado().start();
		

		
		 

	}
	@Bean
	public ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente() {
		return new ServidorEscuchaRegistroCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO, getVentanaChat());
	}
	@Bean
	public ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente() {
		return new ServidorEscuchaMensajeCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, getVentanaChat());
	}
	@Bean
	public ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado() {
		return new ServidorEscuchaSolicitudPrivado(ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, getVentanaChat());
	}
	
}
<<<<<<< HEAD











=======
   
>>>>>>> 6b13729fca9af6439953172a24babb0f632f2741
