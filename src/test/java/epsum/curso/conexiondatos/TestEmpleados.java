package epsum.curso.conexiondatos;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.entidades.Empleado;
import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.servicios.DatoLaboralService;
import epsum.curso.conexiondatos.servicios.DatosPersonalesService;
import epsum.curso.conexiondatos.servicios.EmpleadoService;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import lombok.Data;

@SpringBootTest
@Data
public class TestEmpleados {
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private DatoLaboralService datoLaboralService;
	@Autowired
	private DatosPersonalesService datosPersonalesService;
	@Autowired
	private EmpresaService empresaService;
	
	@Test
	public void alta() {
		System.setProperty("java.awt.headless", "false");
		Empleado empleado = new Empleado();	
		empleado.setNombre("Shinji");
		empleado.setDni("secreto");
		empleado.setEmail("secreto");
		empleado.setTelefono("secreto");
		empleado.setEmpresa(((List<Empresa>)getEmpresaService().findAll()).get(0));
		empleado.setDatoLaboral(((List<DatoLaboral>)getDatoLaboralService().findAll()).get(0));
		empleado.setDatoPersonal(((List<DatoPersonal>)getDatosPersonalesService().findAll()).get(0));
		getEmpleadoService().save(empleado);
		getEmpleadoService().deleteById(empleado.getId());
	}
	
	public void modificar() {
		System.setProperty("java.awt.headless", "false");
		Empleado empleado = new Empleado();	
		empleado.setNombre("Shinji");
		empleado.setDni("secreto");
		empleado.setEmail("secreto");
		empleado.setTelefono("secreto");
		empleado.setEmpresa(((List<Empresa>)getEmpresaService().findAll()).get(0));
		empleado.setDatoLaboral(((List<DatoLaboral>)getDatoLaboralService().findAll()).get(0));
		empleado.setDatoPersonal(((List<DatoPersonal>)getDatosPersonalesService().findAll()).get(0));
		getEmpleadoService().save(empleado);
		empleado.setNombre("Manuel");
		getEmpleadoService().save(empleado);
		getEmpleadoService().deleteById(empleado.getId());
	}
}
