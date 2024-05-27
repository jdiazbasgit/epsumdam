package epsum.curso.chat.ventanas;

import java.awt.Frame;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

=======
>>>>>>> refs/remotes/origin/chat-rodrigo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.servidores.LevantarServidor;
import epsum.curso.chat.ventanas.servidores.ServidorChat;
=======
import org.springframework.context.annotation.Import;
import epsum.curso.chat.ventanas.configuration.ClienteConfiguration;
>>>>>>> refs/remotes/origin/chat-rodrigo
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@SpringBootApplication
@Data
@Import(ClienteConfiguration.class)
public class VerVentanaChat extends Frame implements CommandLineRunner {
<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/chat-rodrigo
	@Autowired
	private VentanaChat ventanaChat;
	
	@Autowired
	private ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente;
	
	@Autowired
	private ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente;
	
	@Autowired
	private ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado;
	
	public static void main(String[] args) {
<<<<<<< HEAD
		
		
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(LevantarServidor.class);
=======
		SpringApplicationBuilder builder = new SpringApplicationBuilder(VerVentanaChat.class);
>>>>>>> refs/remotes/origin/chat-rodrigo
		builder.headless(false);
		builder.run(args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
<<<<<<< HEAD
=======
		getVentanaChat().setVisible(true);
		getServidorEscuchaRegistroCliente().start();
		getServidorEscuchaMensajeCliente().start();
		getServidorEscuchaSolicitudPrivado().start();
	}
>>>>>>> refs/remotes/origin/chat-rodrigo

		
		servidorEscuchaMensajeCliente().start();
		servidorEscuchaRegistroCliente().start();
		servidorEscuchaSolicitudPrivado().start();
		getVentanaChat().setVisible(true);

		getVentanaChat().setVisible(true);
		 

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
   