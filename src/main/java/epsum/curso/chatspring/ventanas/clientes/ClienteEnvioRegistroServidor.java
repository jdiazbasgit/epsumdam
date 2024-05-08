package epsum.curso.chatspring.ventanas.clientes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import lombok.Data;

@Data
public class ClienteEnvioRegistroServidor extends ClienteChat {

	private Map<String, String> usuarios;
	
	public ClienteEnvioRegistroServidor(String ip, int puerto,Map<String, String> usuarios) {
		super(ip, puerto);
		this.usuarios=usuarios;
	}

	@Override
	public void hacerAlgo() throws IOException {
		ObjectOutputStream objectOutputStream= new ObjectOutputStream(getSocket().getOutputStream());
		objectOutputStream.writeObject(getUsuarios());
		objectOutputStream.flush();
	}

}
