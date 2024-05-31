package epsum.curso.chatspring.ventanas.clientes;

import java.io.IOException;

import epsum.curso.chatspring.ventanas.VentanaChat;
import lombok.Data;
@Data
public class ClienteenvioPeticionPrivado extends ClienteChat {

	
	private VentanaChat ventanaChat;

	public ClienteenvioPeticionPrivado(String ip, int puerto) {
		super(ip, puerto);
		this.ventanaChat = ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {
		enviarTexto(String.valueOf(getVentanaChat().getPuerto()));

	}

}
