package epsum.curso.chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import lombok.Data;

public class Ventana extends Frame {
	
	private Panel pSuperior, pInferior, pCentral, pIzquierdo, pSuperiorIzquierdo, pInferiorIzquierdo;
	private Label lNick, lUsuarios, lMensaje;
    private TextField tNick, tMensaje;
    private Button bRegistrar, bEnviar;
    private TextArea taMensajes, taUsuarios;
	
    public Ventana() {
        setSize(500, 500);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        setLayout(new BorderLayout());
        
        pSuperior = new Panel();
        pSuperior.setBackground(Color.BLUE);
        add(pSuperior, BorderLayout.NORTH);
        
        pIzquierdo = new Panel();
        pIzquierdo.setBackground(Color.RED);
        add(pIzquierdo, BorderLayout.WEST);
        
        pCentral= new Panel();
        pCentral.setBackground(Color.ORANGE);
        add(pCentral, BorderLayout.CENTER);
        
        pInferior= new Panel();
        pInferior.setBackground(Color.YELLOW);
        add(pInferior, BorderLayout.SOUTH);
        
        pSuperiorIzquierdo = new Panel();
        
        pInferiorIzquierdo = new Panel();
    
        lNick = new Label("Nick: ");
        tNick = new TextField("", 30); 
        bRegistrar = new Button("Registrar");
        
        pSuperior.add(lNick);
        pSuperior.add(tNick);
        pSuperior.add(bRegistrar);
        
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
}

