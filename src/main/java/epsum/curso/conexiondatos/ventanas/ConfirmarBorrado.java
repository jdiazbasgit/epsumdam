package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.ventanas.PanelComponente;
import lombok.Data;

@Data
public class ConfirmarBorrado extends JDialog implements ActionListener {
	
	@Autowired
	private PanelComponente panelComponente;
	
	private JPanel jPanel;
	private JButton botonSi;
	private JButton botonNo;
	private JLabel jLabel;
	
	public ConfirmarBorrado() {
		setTitle("Confirmar borrado");
		setSize(500,500);
		setLocation(200,200);
		setLayout(new BorderLayout());
		setJLabel(new JLabel("¿ESTÁ SEGURO DE QUE DESEA BORRAR"));
		
		botonSi = new JButton("Sí");
        botonSi.addActionListener(this);
        botonNo = new JButton("No");
        botonNo.addActionListener(this);
	}

	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(botonSi)) {
			panelComponente.baja();
		}
		else {
			System.exit(0);
		}
	}

}
