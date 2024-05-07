package epsum.curso.conexiondatos.ventanas;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.servicios.CargoService;
import lombok.Data;

@Data
public class PanelCargos extends PanelComponente {
	@Autowired
	private CargoService cargoService;

	private Object[] cabeceras;

	private Object[][] datos;

	private String titulo;

	public PanelCargos(Object[] cabeceras, Object[][] datos, String titulo) {
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
		getCargoService().deleteById(id);
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		defaultTableModel.removeRow(getTabla().getSelectedRow());
	}

	@Override
	public void modificar() {
		for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
			Cargo cargo = new Cargo();
			cargo.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
			cargo.setDescripcion((String) getTabla().getModel().getValueAt(i, 1));
			getCargoService().save(cargo);

		}

	}

}
