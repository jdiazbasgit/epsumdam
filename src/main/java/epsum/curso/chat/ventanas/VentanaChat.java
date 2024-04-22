package epsum.curso.chat.ventanas;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import epsum.curso.chat.ventanas.clientes.ClienteChat;
import epsum.curso.chat.ventanas.clientes.ClienteEnvioRegistroCliente;
import epsum.curso.chat.ventanas.servidores.ServidorChat;
import lombok.Data;

@Data
public class VentanaChat extends Frame implements WindowListener,ActionListener {
	private Panel PSuperior, PInferior, PIzquierda, PCentral, PSuperiorIzquierda, PInferiorIzquierda;
	private Button BRegistrar, BEnviar;
	private Label LNick, LMensaje, LUsuarios;
	private TextField TNick, TMensaje;
	private TextArea TAMensajes, TAUsuarios;
	
	public VentanaChat() {
		setSize(500,500);		
		setLayout(new BorderLayout()); 
		setVisible(true);
		this.addWindowListener(this); 
		barraSuperior();
		barraInferior();
		barraIzquierda();
		barraCentral();
		getBRegistrar().addActionListener(this);
		
	}
	
	void barraSuperior() {
		PSuperior = new Panel();
		LNick = new Label("Nick");
		TNick = new TextField(80);
		BRegistrar = new Button("Registrar");
		//PSuperior.setBackground(Color.red);
		PSuperior.setVisible(true);
		add(PSuperior, BorderLayout.NORTH);
		getPSuperior().add(getLNick());
		getPSuperior().add(getTNick());
		getPSuperior().add(getBRegistrar());
	}
	
	void barraInferior() {
		PInferior = new Panel();
		LMensaje = new Label("Mensaje");
		TMensaje = new TextField(90);
		BEnviar = new Button("Enviar");
		//PInferior.setBackground(Color.yellow);
		PInferior.setVisible(true);
		add(PInferior, BorderLayout.SOUTH);
		getPInferior().add(getLMensaje());
		getPInferior().add(getTMensaje());
		getPInferior().add(getBEnviar());
	}
	
	void barraIzquierda() {
		PIzquierda = new Panel();
		PSuperiorIzquierda = new Panel();
		PInferiorIzquierda = new Panel();
		LUsuarios = new Label("Usuarios");
		TAUsuarios = new TextArea(30,30);
		
		//PIzquierda.setBackground(Color.green);
		PIzquierda.setVisible(true);
		add(PIzquierda, BorderLayout.WEST);
		getPIzquierda().setLayout(new BorderLayout());
		getPSuperiorIzquierda().add(getLUsuarios());
		
		getPIzquierda().add(getPSuperiorIzquierda(),BorderLayout.NORTH);
		getPIzquierda().add(getTAUsuarios());
	}
	
	void barraCentral() {
		PCentral = new Panel();
		TAMensajes = new TextArea();
		//PCentral.setBackground(Color.black);
		PCentral.setVisible(true);
		getPCentral().setLayout(new BorderLayout());
		add(PCentral, BorderLayout.CENTER);
		getPCentral().add(getTAMensajes());
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(getBRegistrar())) {
			System.out.println("envio nick desde cliente");
			ClienteEnvioRegistroCliente cliente= new ClienteEnvioRegistroCliente(ClienteChat.SERVIDOR, ServidorChat.PUERTO_ESCUCHA_SERVIDOR_REGISTRO, this);
			cliente.start();
		}
		
	}
}
