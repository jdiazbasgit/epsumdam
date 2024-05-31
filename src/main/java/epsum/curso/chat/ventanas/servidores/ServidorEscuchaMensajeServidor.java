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

<<<<<<< HEAD
<<<<<<< HEAD
	ServidorEscuchaMensajeServidor(int puerto) {
=======
=======
	@Autowired
	private ClienteEnvioMensajeServidor clienteEnvioMensajeServidor;
	
	@Autowired
	private ApplicationContext applicationContext;
>>>>>>> 367be938385de1d563a3d67468ec053d558607d9
	public ServidorEscuchaMensajeServidor(int puerto) {
>>>>>>> 6b13729fca9af6439953172a24babb0f632f2741

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
			clienteEnvioMensajeServidor.setMensajeSalida(mensaje);
			clienteEnvioMensajeServidor.start();
		});
		
	}

}

