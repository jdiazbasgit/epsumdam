package epsum.curso.chatspring.ventanas;

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
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import epsum.curso.chatspring.ChatSpringApplication;
import epsum.curso.chatspring.configuracion.ConfiguracionChatSpring;
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@SpringBootApplication
@Data
@Import(ConfiguracionChatSpring.class)
public class VerVentanaChat extends Frame implements CommandLineRunner {
	
	@Autowired
	private VentanaChat ventanaChat;
	
	@Autowired
	private ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente;
	@Autowired
	private ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente;
	@Autowired
	private ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado;
	

	public static void main1(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(VerVentanaChat.class);
		builder.headless(false);
		builder.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		ventanaChat.setVisible(true);
		servidorEscuchaRegistroCliente.start();
		servidorEscuchaMensajeCliente.start();
		servidorEscuchaSolicitudPrivado.start();
		
	}
}
