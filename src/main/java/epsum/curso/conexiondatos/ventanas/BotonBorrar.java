package epsum.curso.conexiondatos.ventanas;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BotonBorrar extends JButton implements TableCellRenderer {

	public BotonBorrar() {
		// TODO Auto-generated constructor stub
	}

	public BotonBorrar(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public BotonBorrar(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public BotonBorrar(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public BotonBorrar(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText("BORRAR");
		return this;
	}

}
