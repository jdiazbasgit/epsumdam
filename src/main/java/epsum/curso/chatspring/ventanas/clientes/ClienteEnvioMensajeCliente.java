package epsum.curso.chatspring.ventanas.clientes;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chatspring.ventanas.VentanaChat;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ClienteEnvioMensajeCliente extends ClienteChat {

	@Autowired
	private VentanaChat ventanaChat;
	
	public ClienteEnvioMensajeCliente(String ip, int puerto) {
		super(ip, puerto);
		//this.ventanaChat= ventanaChat;

	}

	@Override
	public void hacerAlgo() throws IOException {

		PrintWriter printWriter= new PrintWriter(getSocket().getOutputStream());
		printWriter.println(getVentanaChat().getTMensaje().getText());
		enviarTexto(getVentanaChat().getTMensaje().getText());
		getVentanaChat().getTMensaje().setText("");
		printWriter.flush();
		//getVentanaChat().getTMensaje().setText("");

		


	}

}
