package epsum.curso.chatspring.ventanas;

import java.awt.Frame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@Data
@SpringBootApplication
public class VerVentanaChat extends Frame implements CommandLineRunner {
	
	@Autowired
	private VentanaChat ventanaChat;
	@Autowired
	private ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente;
	@Autowired
	private ServidorEscuchaMensajeCliente servidorMensaje;
	@Autowired
	private ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrtivado;
	
	public static void main1(String[] args) {
		
		
	}

	public void run (String...args) throws Exception {
		getVentanaChat().setVisible(true);
		servidorEscuchaRegistroCliente.start();
		servidorEscuchaSolicitudPrtivado.start();
		servidorMensaje.start();
	
	}
	
}