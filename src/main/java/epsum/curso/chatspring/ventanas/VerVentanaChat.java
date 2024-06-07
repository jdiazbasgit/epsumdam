package epsum.curso.chatspring.ventanas;

import java.awt.Frame;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

=======


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import epsum.curso.chatspring.configuracion.ChatSpringConfiguración;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

import epsum.curso.chatspring.ChatSpringApplication;
>>>>>>> refs/remotes/origin/chatSpring
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@SpringBootApplication
@Data
<<<<<<< HEAD

public class VerVentanaChat extends Frame implements CommandLineRunner {
	@Autowired
	private VentanaChat ventanaChat;
	
	@Autowired
	private ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente;
	
	@Autowired
	private ServidorEscuchaMensajeCliente servidorMensaje;
	
	@Autowired
	private ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado;
=======
>>>>>>> refs/remotes/origin/chatSpring

public class VerVentanaChat extends Frame implements CommandLineRunner{
	
	@Autowired
	private ChatSpringConfiguración chatSpringConfiguración;
	@Autowired
	private ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente;
	@Autowired
	private ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente;
	@Autowired
	private ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado;
	@Autowired 
	private VentanaChat ventanaChat;
	
	public static void main1(String[] args) {
<<<<<<< HEAD
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
=======
	
>>>>>>> refs/remotes/origin/chatSpring
	}

<<<<<<< HEAD
=======
	@Override
	public void run(String... args) throws Exception {
	getVentanaChat().setVisible(true);
	servidorEscuchaRegistroCliente.start();
	servidorEscuchaMensajeCliente.start();
	servidorEscuchaSolicitudPrivado.start();
		
	}


>>>>>>> refs/remotes/origin/chatSpring

}

