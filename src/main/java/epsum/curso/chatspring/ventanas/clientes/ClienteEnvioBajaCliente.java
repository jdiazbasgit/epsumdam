package epsum.curso.chatspring.ventanas.clientes;

import java.io.IOException;

public class ClienteEnvioBajaCliente extends ClienteChat {

	public ClienteEnvioBajaCliente(String ip, int puerto) {
		super(ip, puerto);
		
	}

	@Override
	public void hacerAlgo() throws IOException {
		System.out.println("baja realizada correctamente");

	}

}
