package epsum.curso.chatspring.ventanas.servidores;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import epsum.curso.chatspring.ventanas.VentanaChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import lombok.Data;

@Data
public class ServidorEscuchaRegistroCliente extends ServidorChat {

	@Autowired
	private VentanaChat ventanaChat;
	public ServidorEscuchaRegistroCliente(int puerto,VentanaChat ventanaChat) {
		super(puerto);
		this.ventanaChat=ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {
		System.out.println("esperando map");
		Map<String, String> usuarios=(Map<String, String>) recibirObjeto();
		ServidorChat.usuarios=usuarios;
		if(usuarios.size()==0) {
			getVentanaChat().getTAMensajes().append("USUARIO YA EXISTE\n");
			getVentanaChat().getTNick().setEditable(true);
			getVentanaChat().getBRegistrar().setEnabled(true);
		}
		
		else {
			getVentanaChat().getTAUsuarios().setText("");
			usuarios.values().stream().forEach(u->getVentanaChat().getTAUsuarios().append(u+"\n"));
			getVentanaChat().getTNick().setEditable(false);
			getVentanaChat().getBRegistrar().setEnabled(false);
		}
	}
	
	@Bean
	public ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente() {
		ServidorEscuchaRegistroCliente servidorEscuchaRegistroCliente= new  ServidorEscuchaRegistroCliente(ClienteChat.PUERTO_EXCUCHA_CLIENTE_REGISTRO, getVentanaChat());
		return servidorEscuchaRegistroCliente;
	}

}
