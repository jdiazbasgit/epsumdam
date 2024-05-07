package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;

import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import lombok.Data;

@Data
public class PanelEmpresas extends PanelComponente{

	@Autowired
	private EmpresaService empresaService;

	private Object[] cabeceras;

	private Object[][] datos;

	private String titulo;

	public PanelEmpresas(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}
	
	
	@Override
	public void alta() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		Object [] datos = {"0", "",""};
		defaultTableModel.addRow(datos);
		
		}

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
		
		JOptionPane jOptionPane=new JOptionPane("Estas seguro?");
		jOptionPane.setSize(300,300);
		jOptionPane.setLocation(100, 100);
		int confirmation = JOptionPane.showConfirmDialog(null, "¿De verdad quieres borrar?", "Confirmación", JOptionPane.YES_NO_OPTION);
		if (confirmation == JOptionPane.YES_OPTION) {
		getEmpresaService().deleteById(id); // Assuming this method deletes the entry
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		defaultTableModel.removeRow(getTabla().getSelectedRow());
		}

	}

	@Override
	public void modificar() {
		for (int i = 0; i <getTabla().getModel().getRowCount(); i++) {
			Empresa empresa = new Empresa();
			empresa.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
			empresa.setNombre((String) getTabla().getModel().getValueAt(i, 1));
			empresa.setCif((String) getTabla().getModel().getValueAt(i, 2));
			getEmpresaService().save(empresa);
			
		}
		
	}

}
