package epsum.curso.chat.ventanas.clientes;

import java.awt.event.ActionListener;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chat.ventanas.DialogPrivado;
import lombok.Data;

@Data
public class ClienteEnvioMensajePrivado extends ClienteChat {

	@Autowired
	private DialogPrivado dialogPrivado;
	public ClienteEnvioMensajePrivado(String ip, int puerto) {
		super(ip, puerto);
		//this.dialogPrivado=dialogPrivado;
	}

	@Override
	public void hacerAlgo() throws IOException {
		enviarTexto(getDialogPrivado().getJTextField().getText());
		getDialogPrivado().getJTextField().setText("");
		

	}

}
