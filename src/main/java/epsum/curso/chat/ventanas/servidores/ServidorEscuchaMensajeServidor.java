package epsum.curso.chat.ventanas.servidores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioMensajeServidor;

public class ServidorEscuchaMensajeServidor extends ServidorChat {

	ServidorEscuchaMensajeServidor(int puerto) {
		super(puerto);

	}

	@Override
	public void hacerAlgo() throws IOException {
		System.out.println("mensaje enviado al servidor");
		String mensaje = new BufferedReader(new InputStreamReader(getSocket().getInputStream())).readLine();
		
		if (ServidorChat.mensajes == null) {
			ServidorChat.mensajes = new ArrayList<>();
		}
		
		ServidorChat.mensajes.add(mensaje);
		
		ServidorChat.mensajes.stream().forEach(mensaje1 ->{
				ClienteEnvioMensajeServidor clienteEnvioMensajeServidor =
						new ClienteEnvioMensajeServidor(mensaje1, ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, ServidorChat.mensajes);
				clienteEnvioMensajeServidor.start();
			});
	}
}
