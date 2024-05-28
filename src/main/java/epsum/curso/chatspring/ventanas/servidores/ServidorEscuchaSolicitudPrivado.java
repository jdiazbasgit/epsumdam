package epsum.curso.chatspring.ventanas.servidores;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.chatspring.ventanas.DialogPrivado;
import epsum.curso.chatspring.ventanas.VentanaChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteenvioPeticionPrivado;
import lombok.Data;

@Data
public class ServidorEscuchaSolicitudPrivado extends ServidorChat {

	@Autowired
	private VentanaChat ventanaChat;
	private String ipOtro;
	private int puertoDelOtro;
	private boolean primeraVez;
	public ServidorEscuchaSolicitudPrivado(int puerto,VentanaChat ventanaChat) {
		super(puerto);
		this.ventanaChat=ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {
		setPuertoDelOtro(Integer.parseInt(recibirTexto()));
		setIpOtro(getSocket().getInetAddress().getHostAddress());
		DialogPrivado jDialog= new DialogPrivado(getVentanaChat(),ServidorChat.usuarios.get(getIpOtro()),  getVentanaChat().getPuerto(),getIpOtro());
		jDialog.setVisible(true);
		getVentanaChat().setPuerto(getVentanaChat().getPuerto()+1);
		if (!isPrimeraVez()) {
			ClienteenvioPeticionPrivado clienteenvioPeticionPrivado = new ClienteenvioPeticionPrivado(getIpOtro(),
					ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, ventanaChat);
			clienteenvioPeticionPrivado.start();
			setPrimeraVez(true);
		}
		ServidorEscuchaMensajePrivado servidorEscuchaMensajePrivado= new ServidorEscuchaMensajePrivado(getVentanaChat().getPuerto(), ServidorChat.usuarios.get(getIpOtro()), jDialog);
		servidorEscuchaMensajePrivado.start();
		
		
	}
	
	}

