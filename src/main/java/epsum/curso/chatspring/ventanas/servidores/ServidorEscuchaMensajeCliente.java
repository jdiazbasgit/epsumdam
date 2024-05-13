package epsum.curso.chatspring.ventanas.servidores;



import java.io.IOException;

import lombok.Data;


import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chatspring.ventanas.VentanaChat;
import lombok.Data;

@Data
public class ServidorEscuchaMensajeCliente extends ServidorChat {
	@Autowired
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
