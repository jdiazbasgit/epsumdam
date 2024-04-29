package epsum.curso.chat.ventanas.clientes;

import java.awt.event.ActionListener;
import java.io.IOException;

import epsum.curso.chat.ventanas.DialogPrivado;
import lombok.Data;

@Data
public class ClienteEnvioMensajePrivado extends ClienteChat {

	private DialogPrivado dialogPrivado;
	public ClienteEnvioMensajePrivado(String ip, int puerto, DialogPrivado dialogPrivado) {
		super(ip, puerto);
		this.dialogPrivado=dialogPrivado;
	}

	@Override
	public void hacerAlgo() throws IOException {
		enviarTexto(getDialogPrivado().getJTextField().getText());
		getDialogPrivado().getJTextField().setText("");
		

	}

}
