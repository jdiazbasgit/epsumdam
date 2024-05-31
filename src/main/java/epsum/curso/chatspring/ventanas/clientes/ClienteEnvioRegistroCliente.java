package epsum.curso.chatspring.ventanas.clientes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chatspring.ventanas.VentanaChat;
import lombok.Data;

@Data
public class ClienteEnvioRegistroCliente extends ClienteChat {
	
	@Autowired
	private VentanaChat ventanaChat;

	public ClienteEnvioRegistroCliente(String ip, int puerto) {
		super(ip, puerto);
		//this.ventanaChat=ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {
		enviarTexto(getVentanaChat().getTNick().getText());

	}

}
