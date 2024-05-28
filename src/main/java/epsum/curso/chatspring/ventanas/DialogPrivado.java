package epsum.curso.chatspring.ventanas;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioMensajeCliente;
import epsum.curso.chatspring.ventanas.clientes.ClienteEnvioMensajePrivado;
import epsum.curso.chatspring.ventanas.servidores.ServidorEscuchaMensajePrivado;
import lombok.Data;
@Component
@Data
public class DialogPrivado extends JDialog implements ActionListener {
	private JPanel jPanel;
	private JTextField jTextField;
	private JButton jButton;
	private JTextArea jTextArea;
	private int puerto;
	private String ip;
	public DialogPrivado() {
		
		
	}
	

	public DialogPrivado(Frame owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Dialog owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Window owner) {
		super(owner);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Frame owner, boolean modal) {
		super(owner, modal);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Frame owner, String title,int puerto,String ip) {
		super(owner, title);
		this.ip=ip;
		this.puerto=puerto;
		setSize(500,500);
		setLocation(200,200);
		setLayout(new BorderLayout());
		setJTextField(new JTextField(30));
		setJButton(new JButton("ENVIAR"));
		setJTextArea(new JTextArea());
		setJPanel(new JPanel());
		add(getJTextArea(),BorderLayout.CENTER);
		getJPanel().add(getJTextField());
		getJPanel().add(getJButton());
		add(getJPanel(),BorderLayout.SOUTH);
		ServidorEscuchaMensajePrivado servidorEscuchaMensajePrivado= new ServidorEscuchaMensajePrivado(getPuerto(),title,this);
		servidorEscuchaMensajePrivado.start();
		getJButton().addActionListener(this);
	}

	public DialogPrivado(Dialog owner, boolean modal) {
		super(owner, modal);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Dialog owner, String title) {
		super(owner, title);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Window owner, ModalityType modalityType) {
		super(owner, modalityType);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Window owner, String title) {
		super(owner, title);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Window owner, String title, ModalityType modalityType) {
		super(owner, title, modalityType);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		// TODO Auto-generated constructor stub
	}

	public DialogPrivado(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
		super(owner, title, modalityType, gc);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		ClienteEnvioMensajePrivado clienteEnvioMensajePrivado= new ClienteEnvioMensajePrivado(getIp(), getPuerto(),this);
		clienteEnvioMensajePrivado.start();
		getJTextArea().append("YO digo: "+getJTextField().getText()+"\n");		
		getJTextField().setText("");
	}

}
