package epsum.curso.chat.ventanas.servidores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioMensajeServidor;
import lombok.Data;
@Data
public class ServidorEscuchaMensajeServidor extends ServidorChat {

	
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public ServidorEscuchaMensajeServidor(int puerto) {

		super(puerto);
	}

	@Override
	public void hacerAlgo() throws IOException {

		String mensaje=new BufferedReader(new InputStreamReader(getSocket().getInputStream())).readLine();
		String ip=getSocket().getInetAddress().getHostAddress();
		String mensajeSalida=ServidorChat.usuarios.get(ip)+" dice: "+mensaje;
		
		ServidorChat.usuarios.keySet().stream().forEach(ipc->{
			ClienteEnvioMensajeServidor clienteEnvioMensajeServidor=(ClienteEnvioMensajeServidor) getApplicationContext().getBean("clienteEnvioMensajeServidor");
			clienteEnvioMensajeServidor.setIp(ipc);
			clienteEnvioMensajeServidor.setMensajeSalida(mensajeSalida);
			clienteEnvioMensajeServidor.start();
		});
		
	}

}

