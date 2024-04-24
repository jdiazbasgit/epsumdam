package epsum.curso.chat.ventanas.servidores;

import java.io.IOException;
import epsum.curso.chat.ventanas.VentanaChat;
import lombok.Data;

@Data
public class ServidorEscuchaMensajeCliente extends ServidorChat {

	private VentanaChat ventanaChat;

	public ServidorEscuchaMensajeCliente(int puerto, VentanaChat ventanaChat) {
		super(puerto);
		this.ventanaChat=ventanaChat;

	}

	@Override
	public void hacerAlgo() throws IOException {

		getVentanaChat().getTAMensajes().append(recibirTexto()+"\n");


	}

}
