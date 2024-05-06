package epsum.curso.chat.ventanas.servidores;

import java.io.IOException;

import javax.swing.JDialog;

import epsum.curso.chat.ventanas.DialogPrivado;
import lombok.Data;

@Data
public class ServidorEscuchaMensajePrivado extends ServidorChat {
	
	private String otro;
	private DialogPrivado dialogPrivado;
	public ServidorEscuchaMensajePrivado(int puerto, String otro) {
		super(puerto);
		this.otro = otro;
		this.dialogPrivado = dialogPrivado;
		
	}

	@Override
	public void hacerAlgo() throws IOException {
		String mensaje = recibirTexto();
		getDialogPrivado().getJTextArea().append(otro );
		

	}

}
