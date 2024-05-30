package epsum.curso.chat.ventanas.clientes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chat.ventanas.VentanaChat;
import lombok.Data;
@Data
public class ClienteenvioPeticionPrivado extends ClienteChat {

	
	@Autowired
	private VentanaChat ventanaChat;

	public ClienteenvioPeticionPrivado(String ip, int puerto) {
		super(ip, puerto);
		//this.ventanaChat = ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {
		enviarTexto(String.valueOf(getVentanaChat().getPuerto()));

	}

}
