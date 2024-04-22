package epsum.curso.chat.ventanas.servidores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioMensajeServidor;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioRegistroServidor;

public class ServidorEscuchaMensajeServidor extends ServidorChat {

	ServidorEscuchaMensajeServidor(int puerto) {
		super(puerto);
	}

	@Override
	public void hacerAlgo() throws IOException {
		System.out.println("entrada mensaje en servidor");
		String ip =getSocket().getInetAddress().getHostAddress();
		String mensaje=new BufferedReader(new InputStreamReader(getSocket().getInputStream())).readLine();
		
		
			
			
			if(ServidorChat.mensajes==null) {
				ServidorChat.mensajes= new HashMap<>();
			}
			ServidorChat.mensajes.put(ip, mensaje); 
			
			ServidorChat.mensajes.keySet().stream().forEach(ip1->{
				ClienteEnvioMensajeServidor clienteEnvioMensajeServidor=
						new ClienteEnvioMensajeServidor(ip1,ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE,ServidorChat.mensajes);
				clienteEnvioMensajeServidor.start();
			});
		}
		
	}


