package epsum.curso.chatspring.ventanas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import epsum.curso.chatspring.ventanas.clientes.ClienteChat;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioBajaCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioMensajeCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioRegistroCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteenvioPeticionPrivado;
import epsum.curso.chatspring.ventanas.servidores.ServidorChat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import epsum.curso.chat.ventanas.configuracion.Configuracion;

@Component
@Data
@EqualsAndHashCode(callSuper=false)
//@Import(Configuracion.class)
public class VentanaChat extends JFrame implements WindowListener, ActionListener,MouseListener, KeyListener {
	
	private JPanel PSuperior, PInferior, PIzquierda, PCentral, PSuperiorIzquierda, PInferiorIzquierda, pCentralIzquierdaInferior;
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
	//	getBEnviar().addActionListener(this);
		TMensaje.addKeyListener((KeyListener) this);
		getBEnviar().addMouseListener(this);
	//	getBEnviar().addMouseListener(this);
		TAMensajes.setEditable(false);
		TAUsuarios.setEditable(false);
	}

	void barraSuperior() {
		PSuperior = new JPanel();
		LNick = new JLabel("Nick");
		TNick = new JTextField(80);
		BRegistrar = new JButton("Registrar");
		// PSuperior.setBackground(Color.red);
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
		// PInferior.setBackground(Color.yellow);
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
		// PIzquierda.setBackground(Color.green);
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
		// PCentral.setBackground(Color.black);
		PCentral.setVisible(true);
		pCentralIzquierdaInferior = new JPanel();
		bPrivado = new JButton("PRIVADO");
		bPrivado.addActionListener(this);
		getPCentral().setLayout(new BorderLayout());
		add(PCentral, BorderLayout.CENTER);
		getPCentral().add(getTAMensajes());
		getPCentralIzquierdaInferior().add(getBPrivado());
		getPIzquierda().add(getPCentralIzquierdaInferior(), BorderLayout.SOUTH);
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
			System.out.println("envio nick desde cliente");
			clienteEnvioRegistroCliente.start();
			getTMensaje().addKeyListener(this);
		}
		if (e.getSource().equals(getBEnviar())) {

		}
		if (e.getSource().equals(getBPrivado())) {

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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			clienteEnvioMensajeCliente.start();

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
			clienteEnvioMensajeCliente.start();

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
