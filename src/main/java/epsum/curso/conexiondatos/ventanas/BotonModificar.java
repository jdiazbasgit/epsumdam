package epsum.curso.conexiondatos.ventanas;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BotonModificar extends JButton implements TableCellRenderer {

	public BotonModificar() {
		// TODO Auto-generated constructor stub
	}

	public BotonModificar(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public BotonModificar(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public BotonModificar(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public BotonModificar(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText("MODIFICAR");
		return this;
	}

}
