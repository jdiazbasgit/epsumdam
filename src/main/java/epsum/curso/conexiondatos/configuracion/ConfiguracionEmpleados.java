package epsum.curso.conexiondatos.configuracion;

import java.util.List;

import javax.swing.JComboBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	
	public Object[] cabecerasCargos() {
		Object[] cabeceras = { "ID", "NOMBRE", "DNI", "EMAIL", "TELEFONO", "EMPRESAS", "DATOS_PERSONALES",
		"DATOS_LABORALES" };
		return  cabeceras;
	}
	public Object[][] datosEmpleados() {
		List<Empleado> empleados = (List<Empleado>) getEmpleadoService().findAll();
		Object[][] datos = new Object[(int) getEmpleadoService().count()][8];
		int i = 0;
		for (Empleado empleado : empleados) {
			JComboBox<Empresa> comboBoxEmpresa = new JComboBox<Empresa>(((List<Empresa>)getEmpresaService().findAll()).toArray(new Empresa [0]));
			JComboBox<DatoPersonal> comboBoxDatoPersonal = new JComboBox<DatoPersonal>(((List<DatoPersonal>)getDatosPersonalesService().findAll()).toArray(new DatoPersonal [0]));
			JComboBox<DatoLaboral> comboBoxDatoLaboral = new JComboBox<DatoLaboral>(((List<DatoLaboral>)getDatoLaboralService().findAll()).toArray(new DatoLaboral [0]));
			datos[i][0] = String.valueOf(empleado.getId());
			datos[i][1] = empleado.getNombre();
			datos[i][2] = empleado.getDni();
			datos[i][3] = empleado.getEmail();
			datos[i][4] = empleado.getTelefono();
			comboBoxEmpresa.setSelectedItem(empleado.getEmpresa().getNombre());
			datos[i][5] = comboBoxEmpresa;
			comboBoxDatoPersonal.setSelectedItem(empleado.getDatoPersonal().getEstadoCivil().getDescripcion() + " - "
					+ empleado.getDatoPersonal().getHijo().getChicos() + " - "
					+ empleado.getDatoPersonal().getHijo().getChicas());
			datos[i][6] = comboBoxDatoPersonal;
			comboBoxDatoLaboral.setSelectedItem(empleado.getDatoLaboral().getCargo().getDescripcion() + " - "
					+ empleado.getDatoLaboral().getSalario());
			datos[i][7] = comboBoxDatoLaboral;

			i++;
		}
		return datos;
	}
	
	@Bean
	public PanelEmpleado getPanelEmpleados() {
		return new PanelEmpleado(cabecerasCargos(),datosEmpleados(),"EMPLEADOS");
	}
}
