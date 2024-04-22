package epsum.curso.chat.ventanas.servidores;

import java.io.IOException;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioRegistroServidor;

public class ServicorEscuchaBajaServidor extends ServidorChat {

	public ServicorEscuchaBajaServidor(int puerto) {
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
