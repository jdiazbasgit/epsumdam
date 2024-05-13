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
import org.springframework.context.annotation.Bean;

import epsum.curso.chat.ventanas.LevantarServidor;
import epsum.curso.chatspring.ventanas.VentanaChat;
import epsum.curso.chatspring.ventanas.VerVentanaChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@SpringBootApplication
@Data
public class VerVentanaChat extends Frame implements WindowListener, ActionListener, KeyListener, CommandLineRunner {
	@Autowired
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		VentanaChat ventana= new VentanaChat();
		ventana.setVisible(true);
		ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente= 
				new  ServidorEscuchaRegistroCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO, ventana);
		servidorEscuchaRegistroCliente.start();
		ServidorEscuchaMensajeCliente servidorMensaje= new ServidorEscuchaMensajeCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, ventana);
		servidorMensaje.start();
		ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrtivado= new ServidorEscuchaSolicitudPrivado(ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, ventana);
		servidorEscuchaSolicitudPrtivado.start();
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(LevantarServidor.class);
		builder.headless(false);
		builder.run(args);
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
