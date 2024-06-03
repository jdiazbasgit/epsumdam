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

import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@SpringBootApplication
@Data

public class VerVentanaChat extends Frame implements CommandLineRunner {
	@Autowired
	private VentanaChat ventanaChat;
	
	@Autowired
	private ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente;
	
	@Autowired
	private ServidorEscuchaMensajeCliente servidorMensaje;
	
	@Autowired
	private ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado;

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		//VentanaChat ventana= new VentanaChat();
		//ventana.setVisible(true);
		//ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente= 
			//	new  ServidorEscuchaRegistroCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO, ventana);
		//servidorEscuchaRegistroCliente.start();
		//ServidorEscuchaMensajeCliente servidorMensaje= new ServidorEscuchaMensajeCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, ventana);
		//servidorMensaje.start();
		//ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrtivado= new ServidorEscuchaSolicitudPrivado(ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, ventana);
		//servidorEscuchaSolicitudPrtivado.start();
		SpringApplicationBuilder builder = new SpringApplicationBuilder(VerVentanaChat.class);
		builder.headless(false);
		builder.run(args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		getVentanaChat().setVisible(true);
		servidorEscuchaRegistroCliente.start();
		servidorMensaje.start();
		servidorEscuchaSolicitudPrivado.start();
	}


}
