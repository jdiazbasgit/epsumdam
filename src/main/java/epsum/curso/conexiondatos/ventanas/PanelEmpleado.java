package epsum.curso.conexiondatos.ventanas;

import java.awt.BorderLayout;
import java.awt.Label;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import lombok.Data;
@Data
public class PanelEmpleado extends PanelComponente {
	public PanelEmpleado(Object[] cabeceras, Object[][] datos, String titulo) {
		super(cabeceras, datos, titulo);
	}
	
	private EmpresaService empresaService;
	private JDialog dialog1 ;
	private Label lNombre;
	private JTextField tNombre ;
	private Label lDni;
	private JTextField tDni;
	private Label lEmail;
	private JTextField tEmail;
	private Label lTelefono ;
	private JTextField tTelefono ;
	private Label lEmpresa ;
	//private Vector<Empresa> empresas;
	//private JComboBox cEmpresa ;
	private Label lDatoLaboral ;
	private Label lDatoPersonal ;
	
	
	
	@Override
	public void alta() {
		dialog1.setSize(500,500);
		dialog1.setVisible(true);
		lNombre = new Label("Nombre");
		tNombre = new JTextField();
		lDni = new Label("DNI");
		tDni = new JTextField();
		lEmail = new Label("Correo Electrónico");
		tEmail = new JTextField();
		lEmpresa = new Label("Empresa");
		lDatoLaboral = new Label("Dato Laboral");
		lDatoPersonal = new Label("Dato Personal");
		
		dialog1.add(lNombre, BorderLayout.CENTER);

	}

	@Override
	public void baja() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub

	}

}
