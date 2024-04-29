package epsum.curso.chat.ventanas.clientes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import epsum.curso.chat.ventanas.servidores.ServidorChat;
import java.io.PrintWriter;

import java.io.PrintWriter;


import java.io.ObjectOutputStream;
import java.util.Map;

import epsum.curso.chat.ventanas.servidores.ServidorChat;

import lombok.Data;

@Data
public class ClienteEnvioMensajeServidor extends ClienteChat {


	private Map<String, String> mensajes;
	
	public ClienteEnvioMensajeServidor(String ip, int puerto,Map<String, String> mensajes) {
		super(ip, puerto);
		this.mensajes=mensajes;
	}

	@Override
	public void hacerAlgo() throws IOException {
		ObjectOutputStream objectOutputStream= new ObjectOutputStream(getSocket().getOutputStream());
		objectOutputStream.writeObject(getMensajes());
		objectOutputStream.flush();
	
	}
	private String mensajeSalida;
	
	public ClienteEnvioMensajeServidor(String ip, int puerto, String mensajeSalida) {
		super(ip, puerto);
		this.mensajeSalida=mensajeSalida;
	}


	}

}
