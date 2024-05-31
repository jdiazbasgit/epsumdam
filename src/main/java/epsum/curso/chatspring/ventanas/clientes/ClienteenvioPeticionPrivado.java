package epsum.curso.chatspring.ventanas.clientes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chatspring.ventanas.VentanaChat;
import lombok.Data;
@Data
public class ClienteenvioPeticionPrivado extends ClienteChat {

	@Autowired
	private VentanaChat ventanaChat;

	public ClienteenvioPeticionPrivado(String ip, int puerto, VentanaChat ventanaChat) {
		super(ip, puerto);
		//this.ventanaChat = ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {
		enviarTexto(String.valueOf(getVentanaChat().getPuerto()));

	}

}
