package epsum.curso.chat.ventanas;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import lombok.Data;

@Data
public class VentanaChat extends Frame {
	private Panel PSuperior, PInferior, PIzquierda, PCentral, PSuperiorIzquierda, PInferiorIzquierda;
	private Button BRegistrar, BEnviar;
	private Label LNick, LMensaje, LUsuarios;
	private TextField TNick, TMensaje;
	private TextArea TAMensajes, TAUsuarios;
	
	public VentanaChat() {
		setSize(500,500);		
		setLayout(new BorderLayout());
		setVisible(true);
		this.addWindowListener(new ElQueSabeLoQueHayQueHacerConLaVentana());
		
		barraSuperior();
		barraInferior();
		barraIzquierda();
		barraCentral();
		
	}
	
	void barraSuperior() {
		PSuperior = new Panel();
		LNick = new Label("Nick");
		TNick = new TextField(80);
		BRegistrar = new Button("Registrar");
		PSuperior.setBackground(Color.red);
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
		PInferior.setBackground(Color.yellow);
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
		
		PIzquierda.setBackground(Color.green);
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
		PCentral.setBackground(Color.black);
		PCentral.setVisible(true);
		getPCentral().setLayout(new BorderLayout());
		add(PCentral, BorderLayout.CENTER);
		getPCentral().add(getTAMensajes());
	}
}
