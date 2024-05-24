package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import lombok.Data;

@Data
public abstract class PanelComponente extends JPanel implements ActionListener {

	private Object[] cabeceras;
	private Object[][] datos;
	private String titulo;
	private JButton botonAlta;
	private JButton botonBorrar;
	private JButton botonModificar;
	private JTable tabla;
	private JLabel lTitulo;
	private DefaultTableModel defaultTableModel;
	
	public PanelComponente(Object[] cabeceras, Object[][] datos, String titulo) {
		super();
		this.cabeceras = cabeceras;
		this.datos = datos;
		this.titulo = titulo;

		this.botonAlta = new JButton("ALTA");
		this.botonBorrar = new JButton("BORRAR");
		this.botonModificar = new JButton("GRABAR");
		this.botonAlta.addActionListener(this);
		this.botonModificar.addActionListener(this);
		this.botonBorrar.addActionListener(this);

		this.defaultTableModel = new DefaultTableModel(datos, cabeceras);

		this.tabla = new JTable(getDefaultTableModel()) {
			@Override
			public boolean isCellEditable(int row, int column) {

				if (column == 0) {
					return false;

				}
				return true;
			}

			@Override
			public int getRowHeight() {
				return 30;
			}

		};

		for (int i = 0; i < getTabla().getColumnCount(); i++) {
			for (int j = 0; j < getTabla().getRowCount(); j++) {
				if (getTabla().getModel().getValueAt(j, i) instanceof JComboBox<?>) {

					getTabla().getColumnModel().getColumn(i).setCellRenderer( new TableCellRenderer() {

						@Override
						public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
								boolean hasFocus, int row, int column) {
							if (value instanceof JComboBox<?>)
								return (Component) value;
							return null;
						}
					});
				}
			}
		}

		TableColumn column = new TableColumn();
		column.setHeaderValue("ACCIONES");
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

	}

	public void crearPanelBorrado() {
		 JOptionPane.showMessageDialog(null, "Hello World");
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

}
