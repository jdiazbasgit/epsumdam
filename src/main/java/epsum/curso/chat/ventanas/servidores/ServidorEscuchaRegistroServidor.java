package epsum.curso.chat.ventanas.servidores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioRegistroServidor;


public class ServidorEscuchaRegistroServidor extends ServidorChat {

	public ServidorEscuchaRegistroServidor(int puerto) {
		super(puerto);
	}

	@Override
	public void hacerAlgo() throws IOException {
		
		String ip =getSocket().getInetAddress().getHostAddress();
		String nick=new BufferedReader(new InputStreamReader(getSocket().getInputStream())).readLine();
		System.out.println("entrada "+nick+" en servidor");
		Map<String,String> usuariosTemporales=null;
		if(ServidorEscuchaRegistroServidor.usuarios.values().stream().filter(u->u.equals(nick)).count()>0) {
			usuariosTemporales= new HashMap<>();
			ClienteEnvioRegistroServidor clienteEnvioRegistroServidor=
					new ClienteEnvioRegistroServidor(ip,ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO,usuariosTemporales);
			clienteEnvioRegistroServidor.start();
		}
		else {
			System.out.println("envio map a clientes");
			
			if(ServidorChat.usuarios==null) {
				ServidorChat.usuarios= new HashMap<>();
			}
			ServidorChat.usuarios.put(ip, nick);
			
			ServidorChat.usuarios.keySet().stream().forEach(ip1->{
				ClienteEnvioRegistroServidor clienteEnvioRegistroServidor=
						new ClienteEnvioRegistroServidor(ip1,ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO,ServidorChat.usuarios);
				clienteEnvioRegistroServidor.start();
			});
		}
		
	}

}
