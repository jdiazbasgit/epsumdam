package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.List;
import java.util.Vector;

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
	
	private EmpleadoService empleadoService;
	private EmpresaService empresaService;
	private JDialog dialog1;
	private Label lNombre;
	private JTextField tNombre;
	private Label lDni;
	private JTextField tDni;
	private Label lEmail;
	private JTextField tEmail;
	private Label lTelefono;
	private JTextField tTelefono;
	private Label lEmpresa;
	private JComboBox<Empresa> jComboBoxEmpresa;
	//private Vector<Empresa> empresas;
	//private JComboBox cEmpresa;
	private Label lDatoLaboral;
	private Label lDatoPersonal;
	private JComboBox<DatoLaboral> DatoLaboral;
	private Panel panel;
	private JButton bGuardar; 
	
	@Override
	public void alta() {
		
		dialog1 = new JDialog();
		dialog1.setSize(2000,1000);
		dialog1.setVisible(true);
		bGuardar = new JButton("Guardar");
		lNombre = new Label("Nombre");
		//lNombre.setLocation(30,100);
		tNombre = new JTextField(22);
		lDni = new Label("DNI"); 
		tDni = new JTextField(8);
		lEmail = new Label("Correo Electrónico");
		tEmail = new JTextField(22);
		lEmpresa = new Label("Empresa");
		lDatoLaboral = new Label("Dato Laboral");
		lDatoPersonal = new Label("Dato Personal");
		
		Vector <Empresa> vectorEmpresa = (Vector<Empresa>) getEmpresaService().findAll();
		jComboBoxEmpresa = new JComboBox(vectorEmpresa);
		
	
		
		setLayout(new BorderLayout());
		panel = new Panel();
		Panel panel2 = new Panel();
		dialog1.add(panel, BorderLayout.CENTER);
		dialog1.add(panel2, BorderLayout.SOUTH);
		panel.add(lNombre);
		panel.add(tNombre);
		panel.add(lDni);
		panel.add(tDni);
		panel.add(lEmail);
		panel.add(tEmail);
		panel.add(lEmpresa);
		panel.add(jComboBoxEmpresa);
		panel.add(lDatoLaboral);
		panel.add(lDatoPersonal);
		panel2.add(bGuardar);
		//JOptionPane
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
