 package epsum.curso.chatspring.ventanas.servidores;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import epsum.curso.chatspring.ventanas.DialogPrivado;
import epsum.curso.chatspring.ventanas.VentanaChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioMensajePrivado;
import epsum.curso.chatspring.ventanas.clientes.ClienteenvioPeticionPrivado;
import lombok.Data;

@Data
public class ServidorEscuchaSolicitudPrivado extends ServidorChat {

	@Autowired
	private VentanaChat ventanaChat;
	@Autowired
	private ClienteenvioPeticionPrivado clienteenvioPeticionPrivado;
	//@Autowired
	
	private String ipOtro;
	private int puertoDelOtro;
	private boolean primeraVez;
	public ServidorEscuchaSolicitudPrivado(int puerto) {
		super(puerto);
		//this.ventanaChat=ventanaChat;
	}

	@Override
	public void hacerAlgo() throws IOException {
		
		setPuertoDelOtro(Integer.parseInt(recibirTexto()));
		setIpOtro(getSocket().getInetAddress().getHostAddress());
		DialogPrivado jDialog= new DialogPrivado(getVentanaChat(), ServidorChat.usuarios.get(getIpOtro()), getVentanaChat().getPuerto(), getIpOtro());
		jDialog.setVisible(true);
		getVentanaChat().setPuerto(getVentanaChat().getPuerto()+1);
		
		if (!isPrimeraVez()) {
			clienteenvioPeticionPrivado.start();
			setPrimeraVez(true);
		}
		
		ServidorEscuchaMensajePrivado servidorEscuchaMensajePrivado= new ServidorEscuchaMensajePrivado(getVentanaChat().getPuerto(), ServidorChat.usuarios.get(getIpOtro()));
		servidorEscuchaMensajePrivado.start();
		
	}

}
