package epsum.curso.conexiondatos.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JComboBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.entidades.Empleado;
import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.servicios.DatoLaboralService;
import epsum.curso.conexiondatos.servicios.DatosPersonalesService;
import epsum.curso.conexiondatos.servicios.EmpleadoService;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import epsum.curso.conexiondatos.ventanas.PanelEmpleado;
import lombok.Data;

@Configuration
@Data
public class ConfiguracionEmpleados {

	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private DatoLaboralService datoLaboralService;
	
	@Autowired
	private DatosPersonalesService datosPersonalesService;
	
	public String[] cabecerasCargos() {
		Connection conexion=null;
		String[] cabeceras=new String[8] ;
		try {
			conexion= DriverManager.getConnection("jdbc:mysql://192.168.0.126:3306/empresas?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC","curso","Cursocurso1;");
			Statement st=conexion.createStatement();
			ResultSet rs= st.executeQuery("select * from empleados");
			ResultSetMetaData rsmd= rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++)
			{
				cabeceras[i]=rsmd.getColumnName(i+1);
			}
			//Object[] cabeceras = { "ID", "DESCRIPCION" };
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return  cabeceras;
	}
	public Object[][] datosEmpleados() {
		List<Empleado> empleados = (List<Empleado>) getEmpleadoService().findAll();
		Object[][] datos = new Object[(int) getEmpleadoService().count()][8];
		int i = 0;
		for (Empleado empleado : empleados) {
			
			Empresa [] empresas = ((List<Empresa>) getEmpresaService().findAll()).toArray(new Empresa [0]);
			DatoPersonal [] datosPersonales = ((List<DatoPersonal>) getDatosPersonalesService().findAll()).toArray(new DatoPersonal [0]);
			DatoLaboral [] datosLaborales= ((List<DatoLaboral>) getDatoLaboralService().findAll()).toArray(new DatoLaboral [0]);
					datos[i][0] = String.valueOf(empleado.getId());
			datos[i][1] = String.valueOf(empleado.getNombre());
			datos[i][2] = String.valueOf(empleado.getDni());
			datos[i][3] = String.valueOf(empleado.getEmail());
			datos[i][4] = String.valueOf(empleado.getTelefono());
			
			ComboBoxEmpresas comboBoxEmpresas = comboBoxEmpresas (empresas, empleado);
			comboBoxEmpresas.setSelectedItem(empleado.getEmpresa());
			datos[i][5] = comboBoxEmpresas;
			
			ComboBoxDatosPersonales comboBoxDatosPersonales = comboBoxDatosPersonales (datosPersonales, empleado);
			comboBoxDatosPersonales.setSelectedItem(empleado.getDatoPersonal());
			datos[i][6] = comboBoxDatosPersonales;
			
			ComboBoxDatosLaborales comboBoxDatosLaborales = comboBoxDatosLaborales (datosLaborales, empleado);
			comboBoxDatosLaborales.setSelectedItem(empleado.getDatoLaboral());
			datos[i][7] = comboBoxDatosLaborales;

			i++;
		}
		return datos;
	}
	
	@Bean
	@Scope("prototype")
	public ComboBoxEmpresas comboBoxEmpresas(Empresa[] empresas, Empleado empleado) {
		
		
		ComboBoxEmpresas comboBoxEmpresa = new ComboBoxEmpresas(empresas);
		for (int j = 0; j < empresas.length; j++) {
			if (empresas[j].getId() == empleado.getEmpresa().getId())
				comboBoxEmpresa.setSelectedIndex(j);
		}
		return comboBoxEmpresa;
	}
	
	@Bean
	@Scope("prototype")
	public ComboBoxDatosPersonales comboBoxDatosPersonales(DatoPersonal[] datosPersonales, Empleado empleado) {
		
		
		ComboBoxDatosPersonales comboBoxDatoPersonal = new ComboBoxDatosPersonales(datosPersonales);
		for (int j = 0; j < datosPersonales.length; j++) {
			if (datosPersonales[j].getId() == empleado.getDatoPersonal().getId())
				comboBoxDatoPersonal.setSelectedIndex(j);
		}
		return comboBoxDatoPersonal;
	}
	
	@Bean
	@Scope("prototype")
	public ComboBoxDatosLaborales comboBoxDatosLaborales(DatoLaboral[] datosLaborales, Empleado empleado) {
		
		
		ComboBoxDatosLaborales comboBoxDatoLaboral = new ComboBoxDatosLaborales(datosLaborales);
		for (int j = 0; j < datosLaborales.length; j++) {
			if (datosLaborales[j].getId() == empleado.getDatoLaboral().getId())
				comboBoxDatoLaboral.setSelectedIndex(j);
		}
		return comboBoxDatoLaboral;
	}
	
	
	
	@Bean
	public PanelEmpleado getPanelEmpleados() {
		return new PanelEmpleado(cabecerasCargos(),datosEmpleados(),"EMPLEADOS");
	}
}
