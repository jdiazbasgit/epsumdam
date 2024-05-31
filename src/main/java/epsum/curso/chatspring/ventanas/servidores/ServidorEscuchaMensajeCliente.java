package epsum.curso.chatspring.ventanas.servidores;



import java.io.IOException;

import lombok.Data;


import java.io.IOException;
import java.util.Map;

import epsum.curso.chatspring.ventanas.VentanaChat;
import lombok.Data;

@Data
public class ServidorEscuchaMensajeCliente extends ServidorChat {

	private VentanaChat ventanaChat;


	public ServidorEscuchaMensajeCliente(int puerto) {

		super(puerto);
		this.ventanaChat=ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {

		
		getVentanaChat().getTAMensajes().append(recibirTexto()+"\n");


	}

}
