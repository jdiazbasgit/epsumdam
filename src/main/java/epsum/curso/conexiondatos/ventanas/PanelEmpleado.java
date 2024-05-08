package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import epsum.curso.conexiondatos.servicios.EmpleadoService;
import epsum.curso.conexiondatos.entidades.Empleado;
import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import lombok.Data;
@Data
public class PanelEmpleado extends PanelComponente {
	public PanelEmpleado(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}
	private EmpresaService empresaService;
	private EmpleadoService empleadoService;
	private JComboBox<String> selectionModeComboBox;
	
	private Object[] cabeceras;
	
	private Object[][] datos;
	
	private String titulo;
	
	@Override
	public void alta() {
		
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		 Object[] datos = {"0", ""};
		 defaultTableModel.addRow(datos);
		 
  
		 selectionModeComboBox = new JComboBox<String>() { 
             public Dimension getMaximumSize() { 
                 return getPreferredSize(); 
             } 
         }; 
        
         List <Empresa> nombreArrayEmpresa = (List<Empresa>) getEmpresaService().findAll();
        
         for (Empresa empresa : nombreArrayEmpresa) {
        	 selectionModeComboBox.addItem(empresa.getNombre());
          
         }
        
        getTabla().getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(selectionModeComboBox));
	}

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
		getEmpleadoService().deleteById(id);
		 DefaultTableModel defaultTableModel=(DefaultTableModel) getTabla().getModel();
		defaultTableModel.removeRow(getTabla().getSelectedRow());
		
		
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub

	}

}
