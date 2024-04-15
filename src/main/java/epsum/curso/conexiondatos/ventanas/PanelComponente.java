package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import lombok.Data;

@Data
public abstract class PanelComponente extends JPanel implements ActionListener {

	private String[] cabeceras;
	private String[][] datos;
	private String titulo;
	private JButton botonAlta;
	private JButton botonBaja;
	private JButton botonModificar;
	private JTable tabla;
	private JLabel lTitulo;


	public PanelComponente(String[] cabeceras, String[][] datos, String titulo) {
		super();
		this.cabeceras = cabeceras;
		this.datos = datos;
		this.titulo = titulo;
		this.botonAlta = new JButton("alta");
		this.botonBaja = new JButton("baja");
		this.botonModificar = new JButton("modificar");
		this.tabla= new JTable(datos,cabeceras);
		this.setLayout(new BorderLayout());
		this.lTitulo= new JLabel(this.titulo);
		this.add(lTitulo,BorderLayout.NORTH);
		this.add(tabla,BorderLayout.CENTER);
		
	}

	public abstract void alta();

	public abstract void baja();

	public abstract void modificar();

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
