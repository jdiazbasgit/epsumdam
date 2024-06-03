package epsum.curso.chat.ventanas;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioBajaCliente;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioMensajeCliente;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioRegistroCliente;
import epsum.curso.chat.ventanas.clientes.ClienteenvioPeticionPrivado;
import epsum.curso.chat.ventanas.servidores.ServidorChat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Component
public class VentanaChat extends JFrame implements WindowListener, ActionListener, KeyListener {
	
	private ClienteEnvioMensajeCliente clienteEnvioMensajeCliente;
	@Autowired
	private ApplicationContext applicationContext;
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

	private JPanel PSuperior, PInferior, PIzquierda, PCentral, PSuperiorIzquierda, PInferiorIzquierda,
			pCentralIzquierdaInferior;
	private JButton BRegistrar, BEnviar, bPrivado;
	private JLabel LNick, LMensaje, LUsuarios;
	private JTextField TNick, TMensaje;
	private JTextArea TAMensajes, TAUsuarios;
	private int puerto = 9000;

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
		//getBEnviar().addActionListener(this);
		TMensaje.addKeyListener(this);
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
		getpCentralIzquierdaInferior().add(getbPrivado());
		getPIzquierda().add(getpCentralIzquierdaInferior(), BorderLayout.SOUTH);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		ClienteEnvioBajaCliente cliente = new ClienteEnvioBajaCliente(ClienteChat.SERVIDOR,
				ServidorChat.PUERTO_ESCUCHA_SERVIDOR_BAJA);
		cliente.start();
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
		setClienteEnvioMensajeCliente((ClienteEnvioMensajeCliente) getApplicationContext().getBean("clienteEnvioMensajeCliente"));
		getClienteEnvioMensajeCliente().setVentanaChat(this);
		getClienteEnvioMensajeCliente().start();

	}

	private void registrarCliente() {
		
		System.out.println("envio nick desde cliente");
		ClienteEnvioRegistroCliente cliente = new ClienteEnvioRegistroCliente(ClienteChat.SERVIDOR,
				ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO, this);
		cliente.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getBRegistrar())) {
			System.out.println("envio nick desde cliente");
			ClienteEnvioRegistroCliente cliente = new ClienteEnvioRegistroCliente(ClienteChat.SERVIDOR,
					ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO, this);
			cliente.start();
			getTMensaje().addKeyListener(this);
		}
		if (e.getSource().equals(getBEnviar())) {
			enviarMensaje();

		}
		if (e.getSource().equals(getbPrivado())) {

			ServidorChat.usuarios.keySet().stream().forEach(ip -> {
				if (ServidorChat.usuarios.get(ip).equals(getTAUsuarios().getSelectedText())) {
					ClienteenvioPeticionPrivado clienteenvioPeticionPrivado = new ClienteenvioPeticionPrivado(ip,
							ClienteChat.PUERTO_EXCUCHA_CLIENTE_PRIVADO_ALTA, this);
					clienteenvioPeticionPrivado.start();
					setPuerto(getPuerto() + 1);
					
				}

			});
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("code:" + e.getKeyCode());
				System.out.println("char:" + e.getKeyChar());
				//if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(e.getSource().equals(getTMensaje()) && e.getKeyChar()==KeyEvent.VK_ENTER)
					enviarMensaje();

				//}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public ClienteEnvioMensajeCliente getClienteEnvioMensajeCliente() {
		return clienteEnvioMensajeCliente;
	}

	public void setClienteEnvioMensajeCliente(ClienteEnvioMensajeCliente clienteEnvioMensajeCliente) {
		this.clienteEnvioMensajeCliente = clienteEnvioMensajeCliente;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
