package epsum.curso.chatspring.ventanas.servidores;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chatspring.ventanas.VentanaChat;
import lombok.Data;
@Data
public class ServidorEscuchaRegistroCliente extends ServidorChat {

	@Autowired
	private VentanaChat ventanaChat;
	public ServidorEscuchaRegistroCliente(int puerto,VentanaChat ventanaChat) {
		super(puerto);
		//this.ventanaChat=ventanaChat;
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

}
