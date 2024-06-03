package epsum.curso.chat.ventanas.servidores;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.springframework.stereotype.Service;
import epsum.curso.chat.ventanas.DialogPrivado;
import epsum.curso.chat.ventanas.VentanaChat;
import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioMensajePrivado;
import epsum.curso.chat.ventanas.clientes.ClienteenvioPeticionPrivado;
import lombok.Data;

@Data
public class ServidorEscuchaSolicitudPrivado extends ServidorChat {

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