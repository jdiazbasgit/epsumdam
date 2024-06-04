package epsum.curso.conexiondatos.ventanas;

import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.servicios.CargoService;
import epsum.curso.conexiondatos.servicios.DatoLaboralService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.swing.JComboBox;

@Data
public class PanelDatosLaborales extends PanelComponente {

	@Autowired
	private DatoLaboralService datoLaboralService;

	private String[] cabeceras;

	private Object[][] datos;

	private String titulo;

	private int i;

	@Autowired
	private CargoService cargoService;

	private JComboBox<Cargo> jComboBoxCargo;
	

	public PanelDatosLaborales(String[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);

	}

	@Override
	public void alta() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		jComboBoxCargo = new JComboBox<Cargo>();
		List<Cargo> cargos = (List<Cargo>) getCargoService().findAll();
		for (Cargo cargo : cargos) {
			jComboBoxCargo.addItem(cargo);
		}
		Object[] datos = { "0", "0", jComboBoxCargo };
		defaultTableModel.addRow(datos);
	}

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
		getDatoLaboralService().deleteById(id);
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		defaultTableModel.removeRow(getTabla().getSelectedRow());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void modificar() {
		for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
			DatoLaboral datoLaboral = new DatoLaboral();
			datoLaboral.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
			datoLaboral.setSalario(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 1)));
			datoLaboral.setCargo((Cargo)(getTabla().getModel().getValueAt(i, 2)));
			getDatoLaboralService().save(datoLaboral);
			DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
			defaultTableModel.setValueAt(String.valueOf(datoLaboral.getId()), i, 0);
		}
	}

}