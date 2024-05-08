package epsum.curso.chatspring.ventanas.clientes;

import java.io.IOException;

import epsum.curso.chatspring.ventanas.VentanaChat;
import lombok.Data;

@Data
public class ClienteEnvioRegistroCliente extends ClienteChat {
	private VentanaChat ventanaChat;

	public ClienteEnvioRegistroCliente(String ip, int puerto,VentanaChat ventanaChat) {
		super(ip, puerto);
		this.ventanaChat=ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {
		enviarTexto(getVentanaChat().getTNick().getText());

	}

}
