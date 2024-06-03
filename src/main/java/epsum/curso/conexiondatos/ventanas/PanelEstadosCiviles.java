package epsum.curso.conexiondatos.ventanas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.servicios.EstadoCivilService;
import lombok.Data;

@Data

public class PanelEstadosCiviles extends PanelComponente {
	@Autowired
	private EstadoCivilService 	estadoCivilService;
	
	private String[] cabeceras;

	private Object[][] datos;

	private String titulo;

	public PanelEstadosCiviles(String[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}

	@Override
	public void alta() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		Object[] datos = { "0", "" };
		defaultTableModel.addRow(datos);
				
		
		EstadoCivil estadoCivil = new EstadoCivil();
		estadoCivil.setDescripcion(getTabla().getModel().getValueAt(getTabla().getModel().getRowCount() -1, 1).toString());
	}

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));		
		JOptionPane jOptionPane=new JOptionPane("Estas seguro?");
		jOptionPane.setSize(300,300);
		jOptionPane.setLocation(100, 100);
		int confirmation = JOptionPane.showConfirmDialog(null, "¿De verdad quieres borrar?", "Confirmación", JOptionPane.YES_NO_OPTION);
		if (confirmation == JOptionPane.YES_OPTION) {
		getEstadoCivilService().deleteById(id); // Assuming this method deletes the entry
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		defaultTableModel.removeRow(getTabla().getSelectedRow());
		}
		
	}

	@Override
	public void modificar() {
		int fila = 0;
		for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
			EstadoCivil estadoCivil = new EstadoCivil();
			estadoCivil.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
			estadoCivil.setDescripcion((String) getTabla().getModel().getValueAt(i, 1));
			getEstadoCivilService().save(estadoCivil);
			getTabla().getModel().setValueAt(String.valueOf(estadoCivil.getId()),fila, 0);
			fila++;

		}	
		

	}

}
