package epsum.curso.chat.ventanas.servidores;

import java.io.IOException;
import java.util.Map;

import epsum.curso.chat.ventanas.VentanaChat;
import lombok.Data;
@Data
public class ServidorEscuchaMensajeCliente extends ServidorChat {

	private VentanaChat ventanaChat;
	public ServidorEscuchaMensajeCliente(int puerto,VentanaChat ventanaChat) {
		super(puerto);
		this.ventanaChat=ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {
		System.out.println("esperando map");
		Map<String, String> mensajes=(Map<String, String>) recibirObjeto();
		
			getVentanaChat().getTAMensajes().setText("");
			mensajes.values().stream().forEach(u->getVentanaChat().getTAMensajes().append(u+"\n"));
			
		
	}

}
