package epsum.curso.chat.ventanas.servidores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioMensajeServidor;

public class ServidorEscuchaMensajeServidor extends ServidorChat {

	public ServidorEscuchaMensajeServidor(int puerto) {

		super(puerto);
	}

	@Override
	public void hacerAlgo() throws IOException {

		String mensaje=new BufferedReader(new InputStreamReader(getSocket().getInputStream())).readLine();
		String ip=getSocket().getInetAddress().getHostAddress();
		String mensajeSalida=ServidorChat.usuarios.get(ip)+" dice: "+mensaje;
		
		ServidorChat.usuarios.keySet().stream().forEach(ipc->{
			ClienteEnvioMensajeServidor clienteEnvioMensajeServidor= new ClienteEnvioMensajeServidor(ipc, ClienteChat.PUERTO_EXCUCHA_CLIENTE_MENSAJE, mensajeSalida);
			clienteEnvioMensajeServidor.start();
		});
		
	}

}


