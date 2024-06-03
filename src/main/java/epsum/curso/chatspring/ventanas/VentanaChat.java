package epsum.curso.chatspring.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioBajaCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioMensajeCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioRegistroCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteenvioPeticionPrivado;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import epsum.curso.chat.ventanas.configuracion.Configuracion;

@Component
//@Data

//@EqualsAndHashCode(callSuper=false)
//@Import(Configuracion.class)
public class VentanaChat extends JFrame implements WindowListener, ActionListener, KeyListener {

	private JPanel PSuperior, PInferior, PIzquierda, PCentral, PSuperiorIzquierda, PInferiorIzquierda,
			pCentralIzquierdaInferior;
	private JButton BRegistrar, BEnviar, bPrivado;
	private JLabel LNick, LMensaje, LUsuarios;
	private JTextField TNick, TMensaje;
	private JTextArea TAMensajes, TAUsuarios;
	private int puerto = 9000;

	@Autowired
	@Lazy
	private ClienteEnvioMensajeCliente clienteEnvioMensajeCliente;

	@Autowired
	@Lazy
	private ClienteEnvioBajaCliente clienteEnvioBajaCliente;

	public JPanel getPSuperior() {
		return PSuperior;
	}

	public void setPSuperior(JPanel pSuperior) {
		PSuperior = pSuperior;
	}

	public JPanel getPInferior() {
		return PInferior;
	}

	public void setPInferior(JPanel pInferior) {
		PInferior = pInferior;
	}

	public JPanel getPIzquierda() {
		return PIzquierda;
	}

	public void setPIzquierda(JPanel pIzquierda) {
		PIzquierda = pIzquierda;
	}

	public JPanel getPCentral() {
		return PCentral;
	}

	public void setPCentral(JPanel pCentral) {
		PCentral = pCentral;
	}

	public JPanel getPSuperiorIzquierda() {
		return PSuperiorIzquierda;
	}

	public void setPSuperiorIzquierda(JPanel pSuperiorIzquierda) {
		PSuperiorIzquierda = pSuperiorIzquierda;
	}

	public JPanel getPInferiorIzquierda() {
		return PInferiorIzquierda;
	}

	public void setPInferiorIzquierda(JPanel pInferiorIzquierda) {
		PInferiorIzquierda = pInferiorIzquierda;
	}

	public JPanel getpCentralIzquierdaInferior() {
		return pCentralIzquierdaInferior;
	}

	public void setpCentralIzquierdaInferior(JPanel pCentralIzquierdaInferior) {
		this.pCentralIzquierdaInferior = pCentralIzquierdaInferior;
	}

	public JButton getBRegistrar() {
		return BRegistrar;
	}

	public void setBRegistrar(JButton bRegistrar) {
		BRegistrar = bRegistrar;
	}

	public JButton getBEnviar() {
		return BEnviar;
	}

	public void setBEnviar(JButton bEnviar) {
		BEnviar = bEnviar;
	}

	public JButton getbPrivado() {
		return bPrivado;
	}

	public void setbPrivado(JButton bPrivado) {
		this.bPrivado = bPrivado;
	}

	public JLabel getLNick() {
		return LNick;
	}

	public void setLNick(JLabel lNick) {
		LNick = lNick;
	}

	public JLabel getLMensaje() {
		return LMensaje;
	}

	public void setLMensaje(JLabel lMensaje) {
		LMensaje = lMensaje;
	}

	public JLabel getLUsuarios() {
		return LUsuarios;
	}

	public void setLUsuarios(JLabel lUsuarios) {
		LUsuarios = lUsuarios;
	}

	public JTextField getTNick() {
		return TNick;
	}

	public void setTNick(JTextField tNick) {
		TNick = tNick;
	}

	public JTextField getTMensaje() {
		return TMensaje;
	}

	public void setTMensaje(JTextField tMensaje) {
		TMensaje = tMensaje;
	}

	public JTextArea getTAMensajes() {
		return TAMensajes;
	}

	public void setTAMensajes(JTextArea tAMensajes) {
		TAMensajes = tAMensajes;
	}

	public JTextArea getTAUsuarios() {
		return TAUsuarios;
	}

	public void setTAUsuarios(JTextArea tAUsuarios) {
		TAUsuarios = tAUsuarios;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public ClienteEnvioMensajeCliente getClienteEnvioMensajeCliente() {
		return clienteEnvioMensajeCliente;
	}

	public void setClienteEnvioMensajeCliente(ClienteEnvioMensajeCliente clienteEnvioMensajeCliente) {
		this.clienteEnvioMensajeCliente = clienteEnvioMensajeCliente;
	}

	public ClienteEnvioBajaCliente getClienteEnvioBajaCliente() {
		return clienteEnvioBajaCliente;
	}

	public void setClienteEnvioBajaCliente(ClienteEnvioBajaCliente clienteEnvioBajaCliente) {
		this.clienteEnvioBajaCliente = clienteEnvioBajaCliente;
	}

	public ClienteEnvioRegistroCliente getClienteEnvioRegistroCliente() {
		return clienteEnvioRegistroCliente;
	}

	public void setClienteEnvioRegistroCliente(ClienteEnvioRegistroCliente clienteEnvioRegistroCliente) {
		this.clienteEnvioRegistroCliente = clienteEnvioRegistroCliente;
	}

	public ClienteenvioPeticionPrivado getClienteenvioPeticionPrivado() {
		return clienteenvioPeticionPrivado;
	}

	public void setClienteenvioPeticionPrivado(ClienteenvioPeticionPrivado clienteenvioPeticionPrivado) {
		this.clienteenvioPeticionPrivado = clienteenvioPeticionPrivado;
	}

	@Autowired
	@Lazy
	private ClienteEnvioRegistroCliente clienteEnvioRegistroCliente;

	@Autowired
	@Lazy
	private ClienteenvioPeticionPrivado clienteenvioPeticionPrivado;

	public VentanaChat() {
		setSize(500, 500);
		setLayout(new BorderLayout());
		setVisible(true);
		this.addWindowListener(this);
		barraSuperior();
		barraInferior();
		barraIzquierda();
		barraCentral();
		getBRegistrar().addActionListener(this);
		getBEnviar().addActionListener(this);
		// getBEnviar().addMouseListener(this);
		// getTMensaje().addKeyListener(this);
		TMensaje.addKeyListener((KeyListener) this);

		TAMensajes.setEditable(false);
		TAUsuarios.setEditable(false);
	}

	void barraSuperior() {
		PSuperior = new JPanel();
		LNick = new JLabel("Nick");		
		TNick = new JTextField(80);
		BRegistrar = new JButton("Registrar");
		PSuperior.setBackground(Color.orange);
		PSuperior.setVisible(true);
		add(PSuperior, BorderLayout.NORTH);
		getPSuperior().add(getLNick());
		getPSuperior().add(getTNick());
		getPSuperior().add(getBRegistrar());
	}

	void barraInferior() {
		PInferior = new JPanel();
		LMensaje = new JLabel("Mensaje");
		TMensaje = new JTextField(90);
		BEnviar = new JButton("Enviar");
		PInferior.setBackground(Color.orange);
		PInferior.setVisible(true);
		add(PInferior, BorderLayout.SOUTH);
		getPInferior().add(getLMensaje());
		getPInferior().add(getTMensaje());
		getPInferior().add(getBEnviar());
	}

	void barraIzquierda() {
		PIzquierda = new JPanel();
		PSuperiorIzquierda = new JPanel();
		PInferiorIzquierda = new JPanel();
		LUsuarios = new JLabel("Usuarios");
		TAUsuarios = new JTextArea(30, 30);
		TAUsuarios.setEditable(false);
		PIzquierda.setBackground(Color.orange);
		PIzquierda.setVisible(true);
		add(PIzquierda, BorderLayout.WEST);
		getPIzquierda().setLayout(new BorderLayout());
		getPSuperiorIzquierda().add(getLUsuarios());

		getPIzquierda().add(getPSuperiorIzquierda(), BorderLayout.NORTH);
		getPIzquierda().add(getTAUsuarios());
	}

	void barraCentral() {
		PCentral = new JPanel();
		TAMensajes = new JTextArea();
		TAMensajes.setEditable(false);
		PCentral.setBackground(Color.orange);
		PCentral.setVisible(true);
		pCentralIzquierdaInferior = new JPanel();
		bPrivado = new JButton("PRIVADO");
		bPrivado.addActionListener(this);
		getPCentral().setLayout(new BorderLayout());
		add(PCentral, BorderLayout.CENTER);
		getPCentral().add(getTAMensajes());
		getpCentralIzquierdaInferior().add(getbPrivado());
		getPIzquierda().add(getpCentralIzquierdaInferior(), BorderLayout.SOUTH);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		clienteEnvioBajaCliente.start();
		System.exit(0);

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	private void enviarMensaje() {
		clienteEnvioMensajeCliente.start();

	}

	private void registrarCliente() {
		System.out.println("envio nick desde cliente");
		clienteEnvioRegistroCliente.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getBRegistrar())) {
			registrarCliente();
			getTMensaje().addKeyListener(this);
		}
		if (e.getSource().equals(getBEnviar())) {
			enviarMensaje();
		}
		if (e.getSource().equals(getbPrivado())) {

			String nick = this.getTAUsuarios().getSelectedText();
			ServidorChat.usuarios.keySet().stream().forEach(ip -> {
				if (ServidorChat.usuarios.get(ip).equals(nick)) {
					clienteenvioPeticionPrivado.setIp(ip);
				}
			});
			clienteenvioPeticionPrivado.start();
			setPuerto(getPuerto() + 1);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("code:" + e.getKeyCode());
		System.out.println("char:" + e.getKeyChar());
		if (e.getKeyCode() == 10/*KeyEvent.VK_ENTER*/) {
			enviarMensaje();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
