package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import lombok.Data;

@Data
public abstract class PanelComponente extends JPanel implements ActionListener {

	private Object[] cabeceras;
	private Object[][] datos;
	private String titulo;
	private JButton botonAlta;
	private JButton botonBaja;
	private JButton botonModificar;
	private JTable tabla;
	private JLabel lTitulo;
	private DefaultTableModel defaultTableModel;

	public PanelComponente(Object[] cabeceras, Object[][] datos, String titulo) {
		super();
		this.cabeceras = cabeceras;
		this.datos = datos;
		this.titulo = titulo;
		this.botonAlta = new JButton("alta");
		this.botonBaja = new JButton("baja");
		this.botonModificar = new JButton("modificar");
		this.defaultTableModel= new DefaultTableModel(datos, cabeceras);
		this.tabla = new JTable(getDefaultTableModel());
		TableColumn column= new TableColumn();
		column.setHeaderValue("ACCIONES");
		this.setLayout(new BorderLayout(20,20));
		this.lTitulo = new JLabel(this.titulo);
		JPanel panelTitulo= new JPanel();
		panelTitulo.add(lTitulo);
		this.add(panelTitulo, BorderLayout.NORTH);
		JScrollPane jScrollPane= new JScrollPane(tabla);
		this.add(jScrollPane,BorderLayout.CENTER);//, BorderLayout.CENTER);

	}

	public abstract void alta();

	public abstract void baja();

	public abstract void modificar();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(botonAlta)) {
			alta();
		}
		if (e.getSource().equals(botonBaja)) {
			baja();
		}
		if (e.getSource().equals(botonModificar)) {
			modificar();
		}
	}

}
