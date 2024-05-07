package epsum.curso.conexiondatos.ventanas;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.servicios.EstadoCivilService;
import lombok.Data;

@Data

public class PanelEstadosCiviles extends PanelComponente {
	@Autowired
	private EstadoCivilService 	estadoCivilService;
	
	private Object[] cabeceras;

	private Object[][] datos;

	private String titulo;

	public PanelEstadosCiviles(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}

	@Override
	public void alta() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		Object[] datos = { "0", "" };
		defaultTableModel.addRow(datos);
	}

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
		getEstadoCivilService().deleteById(id);
		 DefaultTableModel defaultTableModel=(DefaultTableModel) getTabla().getModel();
		defaultTableModel.removeRow(getTabla().getSelectedRow());
	}

	@Override
	public void modificar() {
		for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
			EstadoCivil estadoCivil = new EstadoCivil();
			estadoCivil.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
			estadoCivil.setDescripcion((String) getTabla().getModel().getValueAt(i, 1));
			getEstadoCivilService().save(estadoCivil);


		}

	}

}
