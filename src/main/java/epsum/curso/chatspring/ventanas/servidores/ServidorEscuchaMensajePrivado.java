package epsum.curso.chatspring.ventanas.servidores;

import java.io.IOException;

import javax.swing.JDialog;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chatspring.ventanas.DialogPrivado;
import lombok.Data;

@Data
public class ServidorEscuchaMensajePrivado extends ServidorChat {
	@Autowired
	private String otro;
	private DialogPrivado dialogPrivado;
	public ServidorEscuchaMensajePrivado(int puerto,String otro,DialogPrivado dialogPrivado) {
		super(puerto);
		this.otro=otro;
		this.dialogPrivado=dialogPrivado;
		
	}

	@Override
	public void hacerAlgo() throws IOException {
		String mensaje= recibirTexto();
		getDialogPrivado().getJTextArea().append(otro+" dice: "+mensaje+"\n");
		
	}

}
