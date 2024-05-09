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
	
	private JComboBox<String> jComboBoxEmpresas;
	
	private JComboBox<String> jComboBoxDatosPersonales;
	
	private JComboBox<String> jComboBoxDatosLaborales;
	
	private Object[] cabeceras;
	
	private Object[][] datos;
	
	private String titulo;
	
	@Override
	public void alta() {
		
		DefaultTableModel defaultTableModel = (DefaultTableModel) getTabla().getModel();
		 Object[] datos = {"0", "","","","","",""};
		 defaultTableModel.addRow(datos);
		 
  
		 jComboBoxEmpresas = new JComboBox<String>();
        
         List <Empresa> nombreArrayEmpresa = (List<Empresa>) getEmpresaService().findAll();
        
         for (Empresa empresa : nombreArrayEmpresa) {
        	 jComboBoxEmpresas.addItem(empresa.getNombre());
         }
         
         getTabla().getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(jComboBoxEmpresas));
         
         jComboBoxDatosPersonales = new JComboBox<String>();
         
         List <DatoPersonal> nombreArrayDatosPersonales = (List<DatoPersonal>) getDatosPersonalesService().findAll();
        
         for (DatoPersonal datoPersonal : nombreArrayDatosPersonales) {
        	 jComboBoxDatosPersonales.addItem(datoPersonal.getEstadoCivil().getDescripcion() + " - "
 					+ datoPersonal.getHijo().getChicos() + " - "
 					+ datoPersonal.getHijo().getChicas());
         }

        getTabla().getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(jComboBoxDatosPersonales));
        
        jComboBoxDatosLaborales = new JComboBox<String>();
        
        List <DatoLaboral> nombreArrayDatosLaborales = (List<DatoLaboral>) getDatoLaboralService().findAll();
       
        for (DatoLaboral datoLaboral : nombreArrayDatosLaborales) {
        	jComboBoxDatosLaborales.addItem(datoLaboral.getCargo().getDescripcion() + " - "
					+ datoLaboral.getSalario());
        }

       getTabla().getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(jComboBoxDatosLaborales));
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
		int id = Integer.parseInt((String) getTabla().getModel().getValueAt(getTabla().getSelectedRow(), 0)); 
		getEmpleadoService().save(null);
		 DefaultTableModel defaultTableModel=(DefaultTableModel) getTabla().getModel();
		defaultTableModel.removeRow(getTabla().getSelectedRow());

	}

}
