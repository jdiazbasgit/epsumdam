package epsum.curso.conexiondatos.ventanas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import lombok.Data;

@Data
public class BotonModificar extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
	JButton renderButton = new JButton();
	JButton editButton = new JButton();
	String text = new String("");
	String toolTipText = new String("");
	private static final long serialVersionUID = 19791L;

	public BotonModificar(ActionListener eListener) {
		super();
		editButton.addActionListener(this); // Para adminitir eventos
		initClass(eListener);
	}

	public BotonModificar(ActionListener eListener, String newTexto, String newToolTipText) {
		super();
		editButton.addActionListener(this);
		initClass(eListener);
		text = newTexto;
		editButton.setText(text);
		renderButton.setText(text);

		toolTipText = newToolTipText;
		editButton.setToolTipText(toolTipText);
		renderButton.setToolTipText(toolTipText);
	}

	private void initClass(ActionListener eListener) {
		editButton.setFocusPainted(false);
		editButton.addActionListener(eListener);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (hasFocus) {
			renderButton.setForeground(table.getForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		} else if (isSelected) {
			renderButton.setForeground(table.getSelectionForeground());
			renderButton.setBackground(table.getSelectionBackground());
		} else {
			renderButton.setForeground(table.getForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		}

		if (text.equals(""))
			renderButton.setText((value == null) ? "" : value.toString());
		else
			renderButton.setText(text);

		return renderButton;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (text.equals(""))
			text = (value == null) ? "" : value.toString();

		editButton.setText(text);
		return editButton;
	}

	public Object getCellEditorValue() {
		return text;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("en boton");
		fireEditingStopped();
	}
}
