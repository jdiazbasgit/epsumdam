package epsum.curso.conexiondatos.ventanas;

import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

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
		int confirmation = JOptionPane.showConfirmDialog(
				null, "¿Estás seguro de borrar el cargo "
						+ getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 1) + "?",
				"Confirmación", JOptionPane.YES_NO_OPTION);
		if (confirmation == JOptionPane.YES_OPTION) {

			try {
				getDatoLaboralService().deleteById(id);
				JOptionPane.showMessageDialog(null, "Registro borrado correctamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				defaultTableModel.removeRow(getTabla().getSelectedRow());
			} catch (DataIntegrityViolationException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Registro no se ha podido borrar porque esta en uso", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (EmptyResultDataAccessException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "El registro no existe, se va a eliminar", "Error",
						JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				defaultTableModel.removeRow(getTabla().getSelectedRow());
			}

		}
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