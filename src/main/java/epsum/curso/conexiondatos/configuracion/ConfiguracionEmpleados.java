package epsum.curso.conexiondatos.configuracion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import epsum.curso.conexiondatos.entidades.Empleado;
import epsum.curso.conexiondatos.servicios.EmpleadoService;
import epsum.curso.conexiondatos.ventanas.PanelEmpleado;
import lombok.Data;

@Configuration
@Data
public class ConfiguracionEmpleados {

	@Autowired
	private EmpleadoService empleadoService;
	
	public Object[] cabecerasCargos() {
		Object[] cabeceras = { "ID", "NOMBRE", "DNI", "EMAIL", "TELEFONO", "EMPRESAS", "DATOS_PERSONALES",
		"DATOS_LABORALES" };
		return  cabeceras;
	}
	public Object[][] datosEmpleados() {
		List<Empleado> empleados = (List<Empleado>) empleadoService.findAll();
		Object[][] datos = new Object[(int) empleadoService.count()][8];
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
