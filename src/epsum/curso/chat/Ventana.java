package epsum.curso.chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.*;
import java.awt.event.*;

import lombok.Data;

import java.awt.Panel;
@Data
public class Ventana extends Frame {

	 public Ventana() {
	        setSize(600, 600);

	        Panel panelNorte = new Panel(new FlowLayout(FlowLayout.CENTER)); 
	        Button b1 = new Button("Registrar");
	        TextField textField = new TextField(80); 
	        Label label = new Label("Nickname:");
	        panelNorte.add(label);
	        panelNorte.add(textField);
	        panelNorte.add(b1);

	        Panel panelIzquierdo = new Panel(new BorderLayout());
	        Label label2 = new Label("Usuarios:");
	        panelIzquierdo.add(label2, BorderLayout.NORTH);
	        label2.setAlignment(Label.CENTER);
	        
	        Panel panelIzquierdoBajo = new Panel(new BorderLayout());
	        TextArea textArea2 = new TextArea(30, 20); 
	        panelIzquierdoBajo.add(textArea2); 
	        panelIzquierdo.add(panelIzquierdoBajo, BorderLayout.CENTER);
	        
	        Panel panelSur = new Panel(new FlowLayout(FlowLayout.CENTER)); 
	        Button b2 = new Button("Enviar");
	        TextField textField3 = new TextField(80); 
	        Label label3 = new Label("Mensaje:");
	        panelSur.add(label3);
	        panelSur.add(textField3);
	        panelSur.add(b2);
	        
	        Panel panelCentral = new Panel(new BorderLayout()); 
	        TextArea textArea = new TextArea(1, 20);
	        Label label4 = new Label("Persona 2 dice:");
	        panelCentral.add(label4);
	        panelCentral.add(textArea);

	        setLayout(new BorderLayout());

	        add(panelNorte, BorderLayout.NORTH);
	        add(panelIzquierdo, BorderLayout.WEST);
	        add(panelSur, BorderLayout.SOUTH);
	        add(panelCentral, BorderLayout.CENTER);
	        panelNorte.setBackground(Color.CYAN);
	        panelIzquierdo.setBackground(Color.GRAY);
	        panelSur.setBackground(Color.CYAN);
	        panelCentral.setBackground(Color.LIGHT_GRAY);
	        
	        addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                System.exit(0);
	            }
	        });
	        
	        setLocationRelativeTo(null);
	 }
        
    }


