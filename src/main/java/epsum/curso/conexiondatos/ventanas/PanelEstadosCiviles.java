package epsum.curso.conexiondatos.ventanas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

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
		
		int confirmation = JOptionPane.showConfirmDialog(null, "¿Deseas agregar un nuevo registro?", "Confirmación",
				JOptionPane.YES_NO_OPTION);
		if (confirmation == JOptionPane.YES_OPTION) {
			try {

				String descripcion = JOptionPane.showInputDialog(null, "Introduce la descripción del nuevo estado civil:",
						"Nueva Descripción", JOptionPane.PLAIN_MESSAGE);

				if (descripcion == null || descripcion.trim().isEmpty()) {
					throw new IllegalArgumentException("La descripción no puede estar vacía");
				}

				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				Object[] datos = { "0", descripcion.trim() };
				defaultTableModel.addRow(datos);

				JOptionPane.showMessageDialog(null, "Registro agregado correctamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);				
					
				int i=0;
				for (i = 0; i < getTabla().getModel().getRowCount(); i++) {
					EstadoCivil estadoCivil = new EstadoCivil();
					estadoCivil.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
					estadoCivil.setDescripcion((String) getTabla().getModel().getValueAt(i, 1));

					getEstadoCivilService().save(estadoCivil);
					DefaultTableModel defaultTableModel2 = (DefaultTableModel) getTabla().getModel();
					defaultTableModel2.setValueAt(String.valueOf(estadoCivil.getId()), i, 0);
					}
				
				JOptionPane.showMessageDialog(null, "Registro agregado correctamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void baja() {
		
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
		int confirmation = JOptionPane.showConfirmDialog(
				null, "¿Estás seguro de borrar el estado civil "
						+ getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 1) + "?",
				"Confirmación", JOptionPane.YES_NO_OPTION);
		if (confirmation == JOptionPane.YES_OPTION) {

			try {
				getEstadoCivilService().deleteById(id);
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

	@Override
	public void modificar() {
		int i = 0;
		try {
			for (i = 0; i < getTabla().getModel().getRowCount(); i++) {
				EstadoCivil estadoCivil = new EstadoCivil();
				estadoCivil.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
				estadoCivil.setDescripcion((String) getTabla().getModel().getValueAt(i, 1));

				getEstadoCivilService().save(estadoCivil);
				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				defaultTableModel.setValueAt(String.valueOf(estadoCivil.getId()), i, 0);
			}
			JOptionPane.showMessageDialog(null, "Las modificaciones se realizaron correctamente", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			// Quitar la fila donde hay error
		} catch (DataIntegrityViolationException e) {
			JOptionPane.showMessageDialog(null, "Error: El estado civil ya existe, se va a eliminar", "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
			defaultTableModel.removeRow(i);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un problema al modificar los datos", "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
