package epsum.curso.chatspring.ventanas.servidores;

import java.io.IOException;

import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioRegistroServidor;

public class ServidorEscuchaBajaServidor extends ServidorChat {

	public ServidorEscuchaBajaServidor(int puerto) {
		super(puerto);
		
	}

	@Override
	public void hacerAlgo() throws IOException {
		ServidorChat.usuarios.remove(getSocket().getInetAddress().getHostAddress());
		ServidorChat.usuarios.keySet().stream().forEach(ip->{
			ClienteEnvioRegistroServidor cliente= 
					new ClienteEnvioRegistroServidor(ip, ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO,ServidorChat.usuarios);
			cliente.start();
		});

	}

}
