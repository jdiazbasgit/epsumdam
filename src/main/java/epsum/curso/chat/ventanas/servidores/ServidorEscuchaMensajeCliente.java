package epsum.curso.chat.ventanas.servidores;



import java.io.IOException;

import epsum.curso.chat.ventanas.VentanaChat;
import lombok.Data;


import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chat.ventanas.VentanaChat;
import lombok.Data;

@Data
public class ServidorEscuchaMensajeCliente extends ServidorChat {

	@Autowired
	private VentanaChat ventanaChat;


	public ServidorEscuchaMensajeCliente(int puerto) {
		super(puerto);
		//this.ventanaChat=ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {

		
		getVentanaChat().getTAMensajes().append(recibirTexto()+"\n");


	}

}
