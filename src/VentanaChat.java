import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class VentanaChat extends Frame {
	
	public VentanaChat() {
		setSize(400, 400);
		
		Button b2 = new Button("registrar");
		
		setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		setLayout(new BorderLayout(50,50));
		TextArea TextArea = new TextArea(20,10);
		
		
		
		add(TextArea, BorderLayout.NORTH);
		add(b2, BorderLayout.NORTH);
		
		
	}
	
	 lUsuarios = new Label("Usuarios");
     taUsuarios = new TextArea("Aquí aparecerán los usuarios");
     pIzquierdo.add(pSuperiorIzquierdo, BorderLayout.NORTH);
     pSuperiorIzquierdo.add(lUsuarios, BorderLayout.NORTH);
     pIzquierdo.add(pInferiorIzquierdo, BorderLayout.SOUTH);
     pInferiorIzquierdo.add(taUsuarios, BorderLayout.SOUTH);
     
     taMensajes = new TextArea("Aquí aparecerán los mensajes");
     pCentral.add(taMensajes);
     
     lMensaje = new Label("Mensaje: ");
     tMensaje = new TextField("", 30); 
     bEnviar = new Button("Enviar");
     
     pInferior.add(lMensaje);
     pInferior.add(tMensaje);
     pInferior.add(bEnviar);
	
	
	

}
