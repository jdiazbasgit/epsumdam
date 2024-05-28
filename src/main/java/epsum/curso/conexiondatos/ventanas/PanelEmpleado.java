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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import epsum.curso.conexiondatos.servicios.DatoLaboralService;
import epsum.curso.conexiondatos.servicios.DatosPersonalesService;
import epsum.curso.conexiondatos.servicios.EmpleadoService;
import epsum.curso.conexiondatos.entidades.Empleado;
import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import lombok.Data;
@Data
public class PanelEmpleado extends PanelComponente {
	private static final String String = null;

	public PanelEmpleado(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private DatosPersonalesService datosPersonalesService;
	@Autowired
	private DatoLaboralService datoLaboralService;
	
	private JComboBox<Empresa> jComboBoxEmpresas;
	
	private JComboBox<DatoPersonal> jComboBoxDatosPersonales;
	
	private JComboBox<DatoLaboral> jComboBoxDatosLaborales;
	
	private Object[] cabeceras;
	
	private Object[][] datos;
	
	private String titulo;
	
	@Override
	public void alta() {
		 int confirmation = JOptionPane.showConfirmDialog(null, "¿Deseas agregar un nuevo registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
		    if (confirmation == JOptionPane.YES_OPTION) {
		
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
  
		 jComboBoxEmpresas = new JComboBox<Empresa>(); 
        
         List <Empresa> nombreArrayEmpresa = (List<Empresa>) getEmpresaService().findAll();
        
         for (Empresa empresa : nombreArrayEmpresa) {
        	 jComboBoxEmpresas.addItem(empresa);
         }
         
      getTabla().getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(jComboBoxEmpresas));
         
         jComboBoxDatosPersonales = new JComboBox<DatoPersonal>();
         
         List <DatoPersonal> nombreArrayDatosPersonales = (List<DatoPersonal>) getDatosPersonalesService().findAll();
        
         for (DatoPersonal datoPersonal : nombreArrayDatosPersonales) {
        	 jComboBoxDatosPersonales.addItem(datoPersonal);
         }

      getTabla().getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(jComboBoxDatosPersonales));
        
        jComboBoxDatosLaborales = new JComboBox<DatoLaboral>();
        
        List <DatoLaboral> nombreArrayDatosLaborales = (List<DatoLaboral>) getDatoLaboralService().findAll();
       
        for (DatoLaboral datoLaboral : nombreArrayDatosLaborales) {
        	jComboBoxDatosLaborales.addItem(datoLaboral);
        }
        
        Object[] datos = {"0", "0","0","0","0",jComboBoxEmpresas,jComboBoxDatosPersonales,jComboBoxDatosLaborales};
        defaultTableModel.addRow(datos);

      getTabla().getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(jComboBoxDatosLaborales));
		    }
	}
	

	@Override
	public void baja() {
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0));
	    int confirmation = JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Confirmación", JOptionPane.YES_NO_OPTION);
	    if (confirmation == JOptionPane.YES_OPTION) {

	        try {
				getEmpleadoService().deleteById(id);
				JOptionPane.showMessageDialog(null, "Registro borrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				 DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
			     defaultTableModel.removeRow(getTabla().getSelectedRow());
			} catch (Exception e) {	
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Registro no se ha podido borrar", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} 

	       
	    }
	}

	@Override
	public void modificar() {
		try {
	        for (int i = 0; i < getTabla().getModel().getRowCount(); i++) {
	            Empleado empleado = new Empleado();
	            empleado.setId(Integer.parseInt((String) getTabla().getModel().getValueAt(i, 0)));
	            empleado.setNombre((String) getTabla().getModel().getValueAt(i, 1));
	            empleado.setDni((String) getTabla().getModel().getValueAt(i, 2));
	            empleado.setEmail((String) getTabla().getModel().getValueAt(i, 3));
	            empleado.setTelefono((String) getTabla().getModel().getValueAt(i, 4));
	            empleado.setEmpresa((Empresa) getTabla().getModel().getValueAt(i, 5));
	            empleado.setDatoLaboral((DatoLaboral) getTabla().getModel().getValueAt(i, 6));
	            empleado.setDatoPersonal((DatoPersonal) getTabla().getModel().getValueAt(i, 7));
	            
	         //Aqui intenta guardarlo:
	            getEmpleadoService().save(empleado);
	            DefaultTableModel defaultTableModel= (DefaultTableModel) getTabla().getModel();
	            defaultTableModel.setValueAt(String.valueOf(empleado.getId()), i, 0);
	        }
	        JOptionPane.showMessageDialog(null, "Las modificaciones fueron exitosas", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	    
	    } catch (DuplicateKeyException e) {
	        JOptionPane.showMessageDialog(null, "Error: Clave duplicada. No se puede guardar el cargo.", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace(); 
	        
	    } catch (DataIntegrityViolationException e) {
	        JOptionPane.showMessageDialog(null, "Error: Violación de integridad. Verifique los datos.", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace(); 
	        
	    }catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Hubo un problema al modificar los datos", "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace(); 
	    }
	}

}
