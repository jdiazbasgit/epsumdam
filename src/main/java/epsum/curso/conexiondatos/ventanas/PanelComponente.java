package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class PanelComponente extends JPanel implements ActionListener {

	private String[] cabeceras;
	private Object[][] datos;
	private String titulo;
	private JButton botonAlta;
	private JButton botonBorrar;
	private JButton botonModificar;
	private JTable tabla;
	private JLabel lTitulo;
	private DefaultTableModel defaultTableModel;

	public PanelComponente(String[] cabeceras, Object[][] datos, String titulo) {
		super();
		this.cabeceras = cabeceras;
		this.datos = datos;
		this.titulo = titulo;

		this.botonAlta = new JButton("ALTA");
		this.botonBorrar = new JButton("BORRAR");
		botonBorrar.setToolTipText("Seleccione el registro que quiera eliminar y después presione BORRAR");
		this.botonModificar = new JButton("GRABAR");
		this.botonAlta.addActionListener(this);
		this.botonModificar.addActionListener(this);
		this.botonBorrar.addActionListener(this);

		DefaultTableModel myTableModel = new DefaultTableModel(datos, cabeceras);

		this.tabla = new JTable(myTableModel);
		for (int i = 0; i < getTabla().getRowCount(); i++) {
			for(int j=0;j<getTabla().getColumnCount();j++)
				if(getTabla().getValueAt(i, j) instanceof JComboBox<?>) {
					JComboBox<?> combobox = (JComboBox<?>) datos[i][j];
					System.err.println(combobox.getSelectedItem());
					combobox.setIgnoreRepaint(false);
					combobox.repaint();
					getTabla().getModel().setValueAt(combobox.getSelectedItem(), i, j);
					
					getTabla().getColumn(cabeceras[j]).setCellEditor(new DefaultCellEditor(combobox));
					

					
				}
			
		}
		//getTabla().setDefaultEditor(JCheckBox.class, new DefaultCellEditor(new JCheckBox()));

		TableColumn column = new TableColumn();
		column.setHeaderValue("ACCIONES");
		column.setCellRenderer(new DefaultTableCellRenderer());
		this.setLayout(new BorderLayout(20, 20));
		this.lTitulo = new JLabel(this.titulo);
		JPanel panelTitulo = new JPanel();
		panelTitulo.add(lTitulo);
		this.add(panelTitulo, BorderLayout.NORTH);
		JPanel panelDatos = new JPanel();
		panelDatos.setLayout(new FlowLayout());
		JScrollPane jScrollPane = new JScrollPane(tabla);
		panelDatos.add(jScrollPane);
		this.add(jScrollPane, BorderLayout.CENTER);// , BorderLayout.CENTER);
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(getBotonAlta());
		panelBotones.add(getBotonBorrar());
		panelBotones.add(getBotonModificar());
		this.add(panelBotones, BorderLayout.SOUTH);
		getTabla().repaint();
		recargar();
	}
	/*
	public void setBotonBorrarToolTip(String text) {
        botonBorrar.setToolTipText("ejemplo");
    }	
	*/
	private void recargar() {
		for(int i=0;i<getTabla().getRowCount();i++)
			for(int j=0;j<getTabla().getColumnCount();j++)
				if(getTabla().getModel().getValueAt(i, j) instanceof JComboBox<?>){
					JComboBox<?> jComboBox= (JComboBox<?>) getTabla().getModel().getValueAt(i, j);
					jComboBox.setSelectedItem(jComboBox.getSelectedItem());
					jComboBox.repaint(); 
					jComboBox.show();
				}
		
	}



	public abstract void alta();

	public abstract void baja();

	public abstract void modificar();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(botonAlta))
			alta();
		if (e.getSource().equals(botonBorrar))
			baja();
		if (e.getSource().equals(botonModificar))
			modificar();
	}

	// marlenepaper

}
