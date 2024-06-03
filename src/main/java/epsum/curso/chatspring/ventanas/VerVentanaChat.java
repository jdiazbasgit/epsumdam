package epsum.curso.chatspring.ventanas;

import java.awt.Frame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
=======
import org.springframework.boot.builder.SpringApplicationBuilder;
>>>>>>> branch 'chatSpring' of https://github.com/jdiazbasgit/epsumdam.git

<<<<<<< HEAD
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
=======
import epsum.curso.chatspring.configuracion.ChatSpringConfiguración;
>>>>>>> branch 'chatSpring' of https://github.com/jdiazbasgit/epsumdam.git
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@Data
<<<<<<< HEAD
@SpringBootApplication
public class VerVentanaChat extends Frame implements CommandLineRunner {
=======
public class VerVentanaChat extends Frame implements CommandLineRunner{
>>>>>>> branch 'chatSpring' of https://github.com/jdiazbasgit/epsumdam.git
	
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
	@Autowired
	private ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente;
	@Autowired
	private ServidorEscuchaMensajeCliente servidorMensaje;
	@Autowired
	private ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrtivado;
	
<<<<<<< HEAD
=======

>>>>>>> branch 'chatSpring' of https://github.com/jdiazbasgit/epsumdam.git
	public static void main1(String[] args) {
<<<<<<< HEAD
		
=======

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
>>>>>>> branch 'chatSpring' of https://github.com/jdiazbasgit/epsumdam.git
		

	}

<<<<<<< HEAD
	public void run (String...args) throws Exception {
		getVentanaChat().setVisible(true);
		servidorEscuchaRegistroCliente.start();
		servidorEscuchaSolicitudPrtivado.start();
		servidorMensaje.start();
	
	}
	
}
=======
}



>>>>>>> branch 'chatSpring' of https://github.com/jdiazbasgit/epsumdam.git
