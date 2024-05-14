package epsum.curso.chat.ventanas;

import java.awt.Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import epsum.curso.chat.configuration.ClienteConfiguration;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaMensajeCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaRegistroCliente;
import epsum.curso.chat.ventanas.servidores.ServidorEscuchaSolicitudPrivado;
import lombok.Data;

@SpringBootApplication
@Data
@Import(ClienteConfiguration.class)
public class VerVentanaChat extends Frame implements CommandLineRunner {
	@Autowired
	private VentanaChat ventanaChat;
	
	@Autowired
	private ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente;
	
	@Autowired
	private ServidorEscuchaMensajeCliente servidorEscuchaMensajeCliente;
	
	@Autowired
	private ServidorEscuchaSolicitudPrivado servidorEscuchaSolicitudPrivado;
	
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(VentanaChat.class);
		builder.headless(false);
		builder.run(args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		getVentanaChat().setVisible(true);
		getServidorEscuchaRegistroCliente().start();
		getServidorEscuchaMensajeCliente().start();
		getServidorEscuchaSolicitudPrivado().start();
	}

	
}
