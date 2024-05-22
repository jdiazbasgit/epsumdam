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

import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.entidades.Empleado;
import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.servicios.DatoLaboralService;
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
	
	public Object[] cabecerasCargos() {
		Connection conexion=null;
		Object[] cabeceras=new Object[7] ;
		try {
			conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/empresas?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC","curso","Cursocurso1;");
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

			datos[i][0] = String.valueOf(empleado.getId());
			datos[i][1] = empleado.getNombre();
			datos[i][2] = empleado.getDni();
			datos[i][3] = empleado.getEmail();
			datos[i][4] = empleado.getTelefono();
			datos[i][5] = empleado.getEmpresa().getNombre();
			datos[i][6] = empleado.getDatoPersonal().getEstadoCivil().getDescripcion() + " - "
					+ empleado.getDatoPersonal().getHijo().getChicos() + " - "
					+ empleado.getDatoPersonal().getHijo().getChicas();
			datos[i][7] = empleado.getDatoLaboral().getCargo().getDescripcion() + " - "
					+ empleado.getDatoLaboral().getSalario();

			i++;
		}
		return datos;
	}
	
	@Bean
	public PanelEmpleado getPanelEmpleados() {
		return new PanelEmpleado(cabecerasCargos(),datosEmpleados(),"EMPLEADOS");
	}
}
