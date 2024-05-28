package epsum.curso.conexiondatos.ventanas;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class MyTableModel extends DefaultTableModel  {

	/** Nombre de las columnas. */
	private String[] columnNames;
	/** Datos. */
	private Object[][] data;

	/**
	 * Constructor.
	 * 
	 * @param datos     Nombres de las columnas
	 * @param cabeceras Datos de la tabla
	 */
	public MyTableModel(Object[][] datos, String[] cabeceras) {
		this.columnNames = cabeceras;
		this.data = datos;
	}

	@Override
	public String getColumnName(int column) {
		// Nombre de las columnas para la cabecera
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		// Devuelve el número de filas
		return data != null ? data.length : 0;
	}

	@Override
	public int getColumnCount() {
		// Devuelve el número de columnas
		return columnNames.length;
	}

	/**
	 * Nos devolverá la clase que contiene cada columna, es necesario para trabajar
	 * correctamente con los componentes que mostraremos en la tabla.
	 */
	@Override
	public Class getColumnClass(int columnIndex) {
		Class clazz = Object.class;

		Object aux = getValueAt(0, columnIndex);
		if (aux != null) {
			clazz = aux.getClass();
		}
		

		return clazz;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Devuelve el valor que se debe mostrar en la tabla en cada celda
		return data[rowIndex][columnIndex];
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Si queremos que la tabla sea editable deberemos establecer estos valores
		data[rowIndex][columnIndex] = aValue;
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex==0)
			return false;
		return true;
	}

	/**
	 * Nos servira para limpiar la información de una fila
	 * 
	 * @param row
	 */
	public void reset(int row) {

		for (int i = 0; i < data[row].length - 1; i++) {
			// Para las columnas con String
			if (getColumnClass(i) == String.class) {
				setValueAt("", row, i);
			} else if (getColumnClass(i) == Boolean.class) {
				setValueAt(false, row, i);
			}
		}

	}

}

class MyTable extends JTable {

	/**
	 * Constructor.
	 */
	public MyTable() {

		this.setRowHeight(30);

		JComboBox states = new JComboBox(new String[] { "España", "Argentina", "EEUU" });

		String[] columnNames = new String[] { "Nombre", "email", "Fumador", "Nacionalidad", "" };
		Object[][] data = new Object[][] {
				{ "Angel", "angelarcosheredia@gmail.com", false, "Click para elegir", new JButton("Reset") },
				{ "Juan", "juan@gmail.com", false, "Click para elegir", new JButton("Reset") },
				{ "Ana", "ana@hotmail.com", false, "Click para elegir", new JButton("Reset") } };

		MyTableModel model = new MyTableModel(data, columnNames);

		// Establecemos el modelo
		this.setModel(model);

		// Establecemos el renderer y editor que usaremos para el boton
		this.setDefaultRenderer(JButton.class, new ButtonCellRenderer());
		this.setDefaultEditor(JButton.class, new ButtonCellEditor());

		// Editores para cada tipo de objeto, estos nos permitirán darles el
		// comportamiento adecuado
		this.getColumn("Nacionalidad").setCellEditor(new DefaultCellEditor(states));
		this.setDefaultEditor(JCheckBox.class, new DefaultCellEditor(new JCheckBox()));

	}

}

class ButtonCellRenderer implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		// Devolvemos el botón tal cual
		if (value instanceof JButton) {
			return (JButton) value;
		}

		return null;

	}

}

class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor {

	/** Componente que estamos editando. */
	private Component currentValue;

	@Override
	public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, final int row,
			int column) {

		JButton button = null;

		if (value instanceof JButton) {
			button = (JButton) value;
			// Action que permite "limpiar" los valores de una fila
			button.setAction(new AbstractAction("Reset") {

				@Override
				public void actionPerformed(ActionEvent e) {
					((MyTableModel) table.getModel()).reset(row);

				}
			});
		}

		currentValue = button;

		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return currentValue;
	}

}
