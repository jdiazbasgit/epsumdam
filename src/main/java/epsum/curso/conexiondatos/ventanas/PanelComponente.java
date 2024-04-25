package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import lombok.Data;

@Data
public abstract class PanelComponente extends JPanel {

	private Object[] cabeceras;
	private Object[][] datos;
	private String titulo;
	private JButton botonAlta;
	private BotonBorrar botonBorrar;
	private BotonModificar botonModificar;
	private JTable tabla;
	private JLabel lTitulo;
	private DefaultTableModel defaultTableModel;

	public PanelComponente(Object[] cabeceras, Object[][] datos, String titulo) {
		super();
		this.cabeceras = cabeceras;
		this.datos = datos;
		this.titulo = titulo;
		/*
		 * this.botonAlta = new JButton("alta"); this.botonBaja = new JButton("baja");
		 * this.botonModificar = new JButton("modificar");
		 */
		this.defaultTableModel = new DefaultTableModel(datos, cabeceras);
		this.defaultTableModel.addColumn("BORRAR");
		this.defaultTableModel.addColumn("MODIFICAR");

		this.tabla = new JTable(getDefaultTableModel()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public int getRowHeight() {
				// TODO Auto-generated method stub
				return 30;
			}
			
		};
		this.botonModificar = new BotonModificar("MODIFICAR");
		this.botonModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("entro");
				
			}
		});
		this.botonBorrar = new BotonBorrar("BORRAR");
	
		this.tabla.getColumn("MODIFICAR").setCellRenderer(botonModificar);
		this.tabla.getColumn("BORRAR").setCellRenderer(botonBorrar);
		this.tabla.getColumn("MODIFICAR").setWidth(200);
		this.tabla.getColumn("BORRAR").setWidth(100);
		
		TableColumn column = new TableColumn(); 
		column.setHeaderValue("ACCIONES");
		this.setLayout(new BorderLayout(20, 20));
		this.lTitulo = new JLabel(this.titulo);
		JPanel panelTitulo = new JPanel();
		panelTitulo.add(lTitulo);
		this.add(panelTitulo, BorderLayout.NORTH);
		JScrollPane jScrollPane = new JScrollPane(tabla);
		this.add(jScrollPane, BorderLayout.CENTER);// , BorderLayout.CENTER);

	}

	public abstract void alta();

	public abstract void baja();

	public abstract void modificar();



}
