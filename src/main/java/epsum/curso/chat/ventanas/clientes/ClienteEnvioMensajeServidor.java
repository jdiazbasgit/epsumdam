package epsum.curso.chat.ventanas.clientes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ClienteEnvioMensajeServidor extends ClienteChat {

	private List <String> mensajes = new ArrayList <>();
	
	public ClienteEnvioMensajeServidor(String mensaje, int puerto, ArrayList <String> mensajes) {
		super(mensaje, puerto);
		this.mensajes = mensajes;
	}



	@Override
	public void hacerAlgo() throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(getSocket().getOutputStream());
		objectOutputStream.writeObject(getMensajes());
		objectOutputStream.flush();
		
	}

}
