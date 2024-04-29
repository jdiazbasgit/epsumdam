package epsum.curso.chat.ventanas.servidores;

import java.io.IOException;

import javax.swing.JDialog;

import lombok.Data;

@Data
public class ServidorEscuchaMensajePrivado extends ServidorChat {

	private JDialog jDialog;
	public ServidorEscuchaMensajePrivado(int puerto) {
		super(puerto);
		
	}

	@Override
	public void hacerAlgo() throws IOException {
	

	}

}
