package epsum.curso.chat.ventanas.clientes;

import java.io.IOException;

import java.io.PrintWriter;


import epsum.curso.chat.ventanas.VentanaChat;
import lombok.Data;

@Data
public class ClienteEnvioMensajeCliente extends ClienteChat {

	private VentanaChat ventanaChat;
	
	public ClienteEnvioMensajeCliente(String ip, int puerto,VentanaChat ventanaChat) {
		super(ip, puerto);
		this.ventanaChat= ventanaChat;

	}

	@Override
	public void hacerAlgo() throws IOException {

		PrintWriter printWriter= new PrintWriter(getSocket().getOutputStream());
		printWriter.println(getVentanaChat().getTMensaje().getText());
<<<<<<< HEAD
		System.out.println(getVentanaChat().getTMensaje().getText());
=======
		getVentanaChat().getTMensaje().setText("");
>>>>>>> origin/chat
		printWriter.flush();
		getVentanaChat().getTMensaje().setText("");

		enviarTexto(getVentanaChat().getTMensaje().getText());


	}

}
