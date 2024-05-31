package epsum.curso.chat.ventanas.servidores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import epsum.curso.chat.ventanas.clientes.ClienteEnvioRegistroServidor;
import lombok.Data;


@Data
public class ServidorEscuchaRegistroServidor extends ServidorChat {

	@Autowired
	private ClienteEnvioRegistroServidor clienteEnvioRegistroServidor;
	 @Autowired
	    private ApplicationContext applicationContext;

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
			getClienteEnvioRegistroServidor().setIp(ip);
			getClienteEnvioRegistroServidor().setUsuarios(usuariosTemporales);
			getClienteEnvioRegistroServidor().start();
			System.out.println("estado del cliente:"+getClienteEnvioRegistroServidor().getState());
		}
		else {
			System.out.println("envio map a clientes");
			
			if(ServidorChat.usuarios==null) {
				ServidorChat.usuarios= new HashMap<>();
			}
			ServidorChat.usuarios.put(ip, nick);
			
			//ServidorChat.usuarios.keySet().stream().forEach(ip1->{
			for(String ip1:ServidorChat.usuarios.keySet()) {
				System.out.println("estado del cliente0:"+getClienteEnvioRegistroServidor().getState());
				
				ClienteEnvioRegistroServidor clienteEnvioRegistroServidor=(ClienteEnvioRegistroServidor) getApplicationContext().getBean("clienteEnvioRegistroServidor");
				clienteEnvioRegistroServidor.setIp(ip1);
				clienteEnvioRegistroServidor.setUsuarios(ServidorChat.usuarios);
				clienteEnvioRegistroServidor.start();
				System.out.println("estado del cliente1:"+clienteEnvioRegistroServidor.getState());
			};
		}
		
	}

}
