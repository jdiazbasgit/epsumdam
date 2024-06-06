package epsum.curso.conexiondatos.ventanas;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.entidades.Hijo;
import epsum.curso.conexiondatos.servicios.DatosPersonalesService;
import epsum.curso.conexiondatos.servicios.EstadoCivilService;
import epsum.curso.conexiondatos.servicios.HijoService;
import lombok.Data;

@Data
public class PanelDatosPersonales extends PanelComponente {
	public PanelDatosPersonales(String[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}

	@Autowired
	private DatosPersonalesService datosPersonalesService;

	@Autowired
	private EstadoCivilService estadoCivilService;
	@Autowired
	private HijoService hijoService;

	private JComboBox<EstadoCivil> jComboBoxEstadoCivil;

	private JComboBox<Hijo> jComboBoxHijo;

	@Override
	public void alta() {
		int confirmation = JOptionPane.showConfirmDialog(null, "¿Deseas agregar un nuevo registro?", "Confirmacion",
				JOptionPane.YES_NO_OPTION);
		if (confirmation == JOptionPane.YES_OPTION) {

			DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
			jComboBoxEstadoCivil = new JComboBox<EstadoCivil>();
			jComboBoxHijo = new JComboBox<Hijo>();
			List<EstadoCivil> estadosCiviles = (List<EstadoCivil>) getEstadoCivilService().findAll();
			List<Hijo> hijos = (List<Hijo>) getHijoService().findAll();
			for (EstadoCivil estadoCivil : estadosCiviles) {
				jComboBoxEstadoCivil.addItem(estadoCivil);

			}
			for (Hijo hijo : hijos) {
				jComboBoxHijo.addItem(hijo);
			}
			Object[] datos = { "0", jComboBoxEstadoCivil, jComboBoxHijo };
			defaultTableModel.addRow(datos);
			defaultTableModel.setValueAt("Selecciona estado civil", defaultTableModel.getRowCount()-1, 1);
			defaultTableModel.setValueAt("Selecciona hijos", defaultTableModel.getRowCount()-1, 2);
		}

	}

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
		int confirmation = JOptionPane.showConfirmDialog(null,
				"¿Estas seguro de borrar?" + getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 1) + "?");
		if (confirmation == JOptionPane.YES_OPTION) {
			try {
				getDatosPersonalesService().deleteById(id);
				JOptionPane.showMessageDialog(null, "Registro borrado correctamente", "Exito",
						JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				defaultTableModel.removeRow(getTabla().getSelectedRow());
			} catch (DataIntegrityViolationException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Registro no se ha podido borrar porque está en uso", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (EmptyResultDataAccessException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "El registro no exsiste, se va a eliminar", "Error",
						JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				defaultTableModel.removeRow(getTabla().getSelectedRow());
			}
		}
	}

	@Override
	public void modificar() {
		try {
			for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
				DatoPersonal datoPersonal = new DatoPersonal();
				datoPersonal.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
				datoPersonal.setEstadoCivil((EstadoCivil) getTabla().getModel().getValueAt(i, 1));
				datoPersonal.setHijo((Hijo) getTabla().getModel().getValueAt(i, 2));
				getDatosPersonalesService().save(datoPersonal);
				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				defaultTableModel.setValueAt(String.valueOf(datoPersonal.getId()), i, 0);

			}
			JOptionPane.showMessageDialog(null, "Las modificaciones fueron exitosas", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un problema al modificar los datos", "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

}
