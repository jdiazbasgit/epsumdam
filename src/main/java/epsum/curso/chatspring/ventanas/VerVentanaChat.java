package epsum.curso.chatspring.ventanas;

import java.awt.Frame;

<<<<<<< HEAD

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import epsum.curso.chatspring.configuracion.ChatSpringConfiguración;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import epsum.curso.chatspring.configuracion.Configuracion;
>>>>>>> origin/chatSpring
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;
<<<<<<< HEAD
@SpringBootApplication
@Data
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
	
	}

	@Override
	public void run(String... args) throws Exception {
	getVentanaChat().setVisible(true);
	servidorEscuchaRegistroCliente.start();
	servidorEscuchaMensajeCliente.start();
	servidorEscuchaSolicitudPrivado.start();
		
	}


}
=======


@SpringBootApplication
@Data
@Import(Configuracion.class)
public class VerVentanaChat extends Frame implements CommandLineRunner {
	
	@Autowired
	private VentanaChat ventanaChat;
	
	@Autowired
	private static ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente;
	@Autowired
	private static ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente;
	@Autowired
	private static ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado;
	

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
>>>>>>> origin/chatSpring
