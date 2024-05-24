package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

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
		Object [] datos = {"0", "pepe",""};
		defaultTableModel.addRow(datos);
//		Empresa empresa = new Empresa();
//		empresa.setNombre(getTabla().getModel().getValueAt(getTabla().getModel().getRowCount() -1, 1).toString());
//		empresa.setCif(getTabla().getModel().getValueAt(getTabla().getModel().getRowCount() -1, 2).toString());
//		getEmpresaService().save(empresa);
	
		}

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
		
		JOptionPane jOptionPane=new JOptionPane("Estas seguro?");
		jOptionPane.setSize(300,300);
		jOptionPane.setLocation(100, 100);
		int confirmation = JOptionPane.showConfirmDialog(null, "¿De verdad quieres borrar?", "Confirmación", JOptionPane.YES_NO_OPTION);
		if (confirmation == JOptionPane.YES_OPTION) {
		try {
			getEmpresaService().deleteById(id);
			DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
			defaultTableModel.removeRow(getTabla().getSelectedRow());
			JOptionPane.showConfirmDialog(null, "Registro borrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null, "Registro no se ha podido realizar", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		} // Assuming this method deletes the entry
		
		}

	}

	@Override
	public void modificar() {
		int fila = 0;
		for (int i = 0; i <getTabla().getModel().getRowCount(); i++) {
			Empresa empresa = new Empresa();
			empresa.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
			empresa.setNombre((String) getTabla().getModel().getValueAt(i, 1));
			empresa.setCif((String) getTabla().getModel().getValueAt(i, 2));
			getEmpresaService().save(empresa);
			getTabla().getModel().setValueAt(String.valueOf(empresa.getId()),fila, 0);
			fila++;
		}
		
	}

}
