package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import lombok.Data;

@Data
public class PanelEmpresas extends PanelComponente{

	@Autowired
	private EmpresaService empresaService;

	private String[] cabeceras;

	private Object[][] datos;

	private String titulo;

	public PanelEmpresas(String[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}
	
	
	@Override
	public void alta() {
//		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
//		Object [] datos = {"0", "pepe",""};
//		defaultTableModel.addRow(datos);
//		Empresa empresa = new Empresa();
//		empresa.setNombre(getTabla().getModel().getValueAt(getTabla().getModel().getRowCount() -1, 1).toString());
//		empresa.setCif(getTabla().getModel().getValueAt(getTabla().getModel().getRowCount() -1, 2).toString());
//		getEmpresaService().save(empresa);
		int confirmation = JOptionPane.showConfirmDialog(null, "¿Deseas agregar un nuevo registro?", "Confirmación",
				JOptionPane.YES_NO_OPTION);
		if (confirmation == JOptionPane.YES_OPTION) {
			try {

				String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre de la nueva empresa:",
						"Nuevo nombre", JOptionPane.PLAIN_MESSAGE);

				if (nombre == null || nombre.trim().isEmpty()) {
					throw new IllegalArgumentException("El nombre no puede estar vacío");
				}
				
				String cif = JOptionPane.showInputDialog(null, "Introduce el cif de la nueva empresa:",
						"Nuevo cif", JOptionPane.PLAIN_MESSAGE);
				
				if (cif == null || cif.trim().isEmpty()) {
					throw new IllegalArgumentException("El cif no puede estar vacío");
				}

				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				Object[] datos = { "0", nombre.trim(), cif.trim() };
				defaultTableModel.addRow(datos);

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
				null, "¿Estás seguro de borrar la empresa "
						+ getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 1) + "?",
				"Confirmación", JOptionPane.YES_NO_OPTION);
		if (confirmation == JOptionPane.YES_OPTION) {

			try {
				empresaService.deleteById(id);
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
				Empresa empresa = new Empresa();
				empresa.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
				empresa.setNombre((String) getTabla().getModel().getValueAt(i, 1));
				empresa.setCif((String) getTabla().getModel().getValueAt(i, 2));
				getEmpresaService().save(empresa);
				DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
				defaultTableModel.setValueAt(String.valueOf(empresa.getId()), i, 0);
			}
			JOptionPane.showMessageDialog(null, "Las modificaciones se realizaron correctamente", "Éxito",
					JOptionPane.INFORMATION_MESSAGE);

			// Quitar la fila donde hay error
		} catch (DataIntegrityViolationException e) {
			JOptionPane.showMessageDialog(null, "Error: La empresa ya existe, se va a eliminar", "Error",
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
