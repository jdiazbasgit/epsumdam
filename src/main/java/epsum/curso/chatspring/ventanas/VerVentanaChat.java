package epsum.curso.chatspring.ventanas;

import java.awt.Frame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import epsum.curso.chatspring.configuracion.Configuracion;
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;


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