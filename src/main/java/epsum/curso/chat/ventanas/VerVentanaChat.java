package epsum.curso.chat.ventanas;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.servidores.LevantarServidor;
import epsum.curso.chat.ventanas.servidores.ServidorChat;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@SpringBootApplication
@Data
public class VerVentanaChat extends Frame implements CommandLineRunner {

	private VentanaChat ventanaChat;
	public static void main(String[] args) {
		
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

	@Override
	public void run(String... args) throws Exception {
		getVentanaChat().setVisible(true);
		 
	}

	
}
