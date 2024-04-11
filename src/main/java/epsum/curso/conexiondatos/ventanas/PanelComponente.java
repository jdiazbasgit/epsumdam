package epsum.curso.conexiondatos.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import lombok.Data;

@Data
public abstract class PanelComponente extends JPanel implements ActionListener {

	private String[] cabeceras;
	private String[][] datos;
	private String titulo;
	
	public PanelComponente(String[] cabeceras, String[][] datos, String titulo) {
		super();
		this.cabeceras = cabeceras;
		this.datos = datos;
		this.titulo = titulo;
	}
	
	public abstract void alta();
	public abstract void baja();
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
