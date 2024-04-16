package epsum.curso.chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends Frame {
    
    public Ventana() {
        
        setSize(500, 500);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        setLayout(new BorderLayout());
        
        // PANEL SUPERIOR
        Panel pSuperior = new Panel(new FlowLayout(FlowLayout.CENTER));
        pSuperior.setBackground(Color.BLUE);
        add(pSuperior, BorderLayout.NORTH);
        
        Label lNick = new Label("Nick: ");
        TextField tNick = new TextField("", 30); 
        Button bRegistrar = new Button("Registrar");
        pSuperior.add(lNick);
        pSuperior.add(tNick);
        pSuperior.add(bRegistrar);
        
        // PANEL INFERIOR
        Panel pInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        pInferior.setBackground(Color.YELLOW);
        add(pInferior, BorderLayout.SOUTH);
        
        Label lMensaje = new Label("Mensaje: ");
        TextField tMensaje = new TextField("", 30); 
        Button bEnviar = new Button("Enviar");
        
        pInferior.add(lMensaje);
        pInferior.add(tMensaje);
        pInferior.add(bEnviar);
        
        // PANEL CENTRAL
        Panel pCentral = new Panel(new FlowLayout(FlowLayout.CENTER));
        pCentral.setBackground(Color.ORANGE);
        add(pCentral, BorderLayout.CENTER);
        
        TextArea taMensajes = new TextArea("Aquí aparecerán los mensajes");
        pCentral.add(taMensajes);
        
        // PANEL LATERAL
        Panel pLateral = new Panel(new BorderLayout());
        add(pLateral, BorderLayout.WEST);
        pLateral.setBackground(Color.RED);

        Label usuarios = new Label("Usuarios");
        pLateral.add(usuarios, BorderLayout.NORTH);

        // PANEL LATERAL INFERIOR
        Panel pLateralInferior = new Panel(new BorderLayout());
        pLateral.add(pLateralInferior, BorderLayout.CENTER);
        pLateralInferior.setBackground(Color.GREEN);

        TextArea taUsuarios = new TextArea("Aquí aparecerán los usuarios");
        pLateralInferior.add(taUsuarios);
    }
}


	/*
	private Panel pSuperior, pInferior, pCentral, pCentralIzquierdo, pCentralIzquierdoSuperior;
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
        
        //PANEL SUPERIOR
        pSuperior = new Panel(new FlowLayout(FlowLayout.CENTER));
        pSuperior.setBackground(Color.BLUE);
        add(pSuperior, BorderLayout.NORTH);
        
        lNick = new Label("Nick: ");
        tNick = new TextField("", 30); 
        bRegistrar = new Button("Registrar");
        pSuperior.add(lNick);
        pSuperior.add(tNick);
        pSuperior.add(bRegistrar);
        
        //PANEL INFERIOR
        pInferior= new Panel();
        pInferior.setBackground(Color.YELLOW);
        add(pInferior, BorderLayout.SOUTH);
        
        lMensaje = new Label("Mensaje: ");
        tMensaje = new TextField("", 30); 
        bEnviar = new Button("Enviar");
        
        pInferior.add(lMensaje);
        pInferior.add(tMensaje);
        pInferior.add(bEnviar);
        
        //PANEL CENTRAL
        pCentral = new Panel();
        pCentral.setBackground(Color.ORANGE);
        add(pCentral, BorderLayout.CENTER);
        
        taMensajes = new TextArea("Aquí aparecerán los mensajes");
        pCentral.add(taMensajes);
        
        
        //PANEL  CENTRAL IQUIERDO
        pCentralIzquierdo = new Panel();
        
        pCentral.add(pCentralIzquierdo);
        
        taUsuarios = new TextArea("Aquí aparecerán los usuarios");
        pCentralIzquierdo.add(taUsuarios);
        pCentralIzquierdoSuperior.add(pCentralIzquierdo, BorderLayout.CENTER);
        
        //PANEL CENTRAL SUPERIOR IZQUIERDO
        pCentralIzquierdoSuperior = new Panel();
        add(pCentralIzquierdoSuperior, BorderLayout.WEST);
        
        lUsuarios = new Label("Usuarios");
        pCentralIzquierdoSuperior.add(lUsuarios);
        pCentralIzquierdo.add(pCentralIzquierdoSuperior);
        */


