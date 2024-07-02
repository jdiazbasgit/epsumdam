package com.example.demo.controladores;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Articulo;
import com.example.demo.entidades.Cargo;
import com.example.demo.entidades.Comision;
import com.example.demo.entidades.DatoLaboral;
import com.example.demo.entidades.DatoPersonal;
import com.example.demo.entidades.Empleado;
import com.example.demo.entidades.Empresa;
import com.example.demo.entidades.EstadoCivil;
import com.example.demo.entidades.Hijo;
import com.example.demo.entidades.TiposIva;
import com.example.demo.entidades.Venta;
import com.example.demo.repositorios.ArticuloCrudRepository;
import com.example.demo.repositorios.CargoCrudRepository;
import com.example.demo.repositorios.ComisionesCrudRepository;
import com.example.demo.repositorios.DatoLaboralCrudRepository;
import com.example.demo.repositorios.DatosPersonalesCrudRepository;
import com.example.demo.repositorios.EmpleadoCrudRepository;
import com.example.demo.repositorios.EmpresaCrudRepository;
import com.example.demo.repositorios.EstadoCivilCrudRepository;
import com.example.demo.repositorios.HijoCrudRepository;
import com.example.demo.repositorios.TiposIvaCrudRepository;
import com.example.demo.repositorios.VentaCrudRepository;

import lombok.Data;

@RestController
//@Data
public class DesarrolloRestController {

	@Autowired
	private ComisionesCrudRepository comisionesCrudRepository;
	@Autowired
	private EmpresaCrudRepository empresaCrudRepository;
	@Autowired
	private EmpleadoCrudRepository empleadoCrudRepository;
	@Autowired
	private DatoLaboralCrudRepository datoLaboralCrudRepository;
	@Autowired
	private DatosPersonalesCrudRepository datosPersonalesCrudRepository;
	@Autowired
	private CargoCrudRepository cargoCrudRepository;
	@Autowired
	private EstadoCivilCrudRepository estadoCivilCrudRepository;
	@Autowired
	private HijoCrudRepository hijoCrudRepository;
	@Autowired
	private ArticuloCrudRepository articuloCrudRepository;
	@Autowired
	private TiposIvaCrudRepository tiposIvaCrudRepository;
	@Autowired
	private VentaCrudRepository ventaCrudRepository;

	@CrossOrigin(origins = "*")
	@GetMapping("empleados/{id}")
	public Empleado getEmpleadoById( @PathVariable int id) {
		return getEmpleadoCrudRepository().findById(id).get();

	}

	@CrossOrigin(origins = "*")
	@GetMapping("empresas/{id}")
	public Empresa getEmpresaoById( @PathVariable int id) {
		return getEmpresaCrudRepository().findById(id).get();

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("datosLaborales/{id}")
	public DatoLaboral getdlById( @PathVariable int id) {
		return getDatoLaboralCrudRepository().findById(id).get();

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("datosPersonales/{id}")
	public DatoPersonal getdpById( @PathVariable int id) {
		return getDatosPersonalesCrudRepository().findById(id).get();

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("cargos/{id}")
	public Cargo getcById( @PathVariable int id) {
		return getCargoCrudRepository().findById(id).get();

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("estadosCiviles/{id}")
	public EstadoCivil getecById( @PathVariable int id) {
		return getEstadoCivilCrudRepository().findById(id).get();

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("hijos/{id}")
	public Hijo getEmhleadoById( @PathVariable int id) {
		return getHijoCrudRepository().findById(id).get();

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("articulos/{id}")
	public Articulo getEmaleadoById( @PathVariable int id) {
		return getArticuloCrudRepository().findById(id).get();

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("ventas/{id}")
	public Venta getEmplveadoById( @PathVariable int id) {
		return getVentaCrudRepository().findById(id).get();

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("comisiones/{id}")
	public Comision getEmpcleadoById( @PathVariable int id) {
		return getComisionesCrudRepository().findById(id).get();

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("tiposIva/{id}")
	public TiposIva getEmpletuiadoById( @PathVariable int id) {
		return getTiposIvaCrudRepository().findById(id).get();

	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("comisiones")
	public List<Comision> getComisiones() {
		return (List<Comision>) comisionesCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("empresas")
	public List<Empresa> getEmpresas() {
		return (List<Empresa>) empresaCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("empleados")
	public List<Empleado> getEmpleados() {
		return (List<Empleado>) empleadoCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("datosLaborales")
	public List<DatoLaboral> getDatosLaborales() {
		return (List<DatoLaboral>) datoLaboralCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("datosPersonales")
	public List<DatoPersonal> getDatosPersonales() {
		return (List<DatoPersonal>) datosPersonalesCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("cargos")
	public List<Cargo> getCargos() {
		return (List<Cargo>) cargoCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("estadosCiviles")
	public List<EstadoCivil> getEstadosCiviles() {
		return (List<EstadoCivil>) estadoCivilCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("hijos")
	public List<Hijo> getHijos() {
		return (List<Hijo>) hijoCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("articulos")
	public List<Articulo> getArticulos() {
		return (List<Articulo>) articuloCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("ventas")
	public List<Venta> getVentas() {
		return (List<Venta>) ventaCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("tiposIva")
	public List<TiposIva> getTiposIva() {
		return (List<TiposIva>) tiposIvaCrudRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("empresas")
	public Empresa grabaEmpresa(@RequestBody Empresa dato) {
		return empresaCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("empleados")
	public Empleado grabaEmpleado(@RequestBody Empleado dato) {
		return empleadoCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("datosLaborales")
	public DatoLaboral grabaDatoLaboral(@RequestBody DatoLaboral dato) {
		return datoLaboralCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("datosPersonales")
	public DatoPersonal grabaDatoPersonal(@RequestBody DatoPersonal dato) {
		return datosPersonalesCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("cargos")
	public Object grabaCargo(@RequestBody Cargo dato) {
		return cargoCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("estadosCiviles")
	public EstadoCivil grabaEstadoCivil(@RequestBody EstadoCivil dato) {
		return estadoCivilCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("hijos")
	public Hijo grabaHijo(@RequestBody Hijo dato) {
		return hijoCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("comisiones")
	public Comision grabar(@RequestBody Comision dato) {
		return comisionesCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("ventas")
	public Venta grabar(@RequestBody Venta dato) {
		return ventaCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("articulos")
	public Articulo grabar(@RequestBody Articulo dato) {
		return articuloCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("tiposDeIva")
	public TiposIva grabar(@RequestBody TiposIva dato) {
		return tiposIvaCrudRepository.save(dato);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("comisiones/{id}")
	public void borrarComisiones(@PathVariable int id) {
		comisionesCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("ventas/{id}")
	public void borrarVentas(@PathVariable int id) {
		ventaCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("articulos/{id}")
	public void borrarArticulos(@PathVariable int id) {
		articuloCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("tiposDeIva/{id}")
	public void borrarTipoDeIva(@PathVariable int id) {
		tiposIvaCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("empleados/{id}")
	public void borrarEmpleado(@PathVariable int id) {
		empleadoCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("empresas/{id}")
	public void borrarEmpresa(@PathVariable int id) {
		empresaCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("datosLaborales/{id}")
	public void borrarDatoLaboral(@PathVariable int id) {
		datoLaboralCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("datosPersonales/{id}")
	public void borraDatoPersonal(@PathVariable int id) {
		datosPersonalesCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("cargos/{id}")
	public void borraCargo(@PathVariable int id) {
		cargoCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("estadosCiviles/{id}")
	public void borrarEstadoCivil(@PathVariable int id) {
		estadoCivilCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("hijos/{id}")
	public void borraHijo(@PathVariable int id) {
		hijoCrudRepository.deleteById(id);

	}

	@CrossOrigin(origins = "*")
	@PostMapping("servidor")
	public void servidor(@RequestBody Comision comision) {
		System.out.println(comision.getComision() + " - " + comision.getMaximo() + " - " + comision.getMinimo());
	}

	@CrossOrigin(origins = "*")
	@PostMapping("empresas/{id}")
	public Empresa getEmpresas1(@PathVariable int id) {
		return (Empresa) empresaCrudRepository.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("empleados/{id}")
	public Empleado getEmpleados1(@PathVariable int id) {
		return (Empleado) empleadoCrudRepository.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("datosLaborales/{id}")
	public DatoLaboral getDatosLaborales1(@PathVariable int id) {
		return (DatoLaboral) datoLaboralCrudRepository.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("datosPersonales/{id}")
	public DatoPersonal getDatosPersonales1(@PathVariable int id) {
		return (DatoPersonal) datosPersonalesCrudRepository.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("cargos/{id}")
	public Cargo getCargos1(@PathVariable int id) {
		return (Cargo) cargoCrudRepository.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("estadosCiviles/{id}")
	public EstadoCivil getEstadosCiviles1(@PathVariable int id) {
		return (EstadoCivil) estadoCivilCrudRepository.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("hijos/{id}")
	public Hijo getHijos1(@PathVariable int id) {
		return (Hijo) hijoCrudRepository.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("artculos/{id}")
	public Articulo getArticulos1(@PathVariable int id) {
		return (Articulo) articuloCrudRepository.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("ventas/{id}")
	public Venta getVentas1(@PathVariable int id) {
		return (Venta) ventaCrudRepository.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("tiposIva/{id}")
	public TiposIva getTiposIva1(@PathVariable int id) {
		return (TiposIva) tiposIvaCrudRepository.findById(id).get();
	}

	public ComisionesCrudRepository getComisionesCrudRepository() {
		return comisionesCrudRepository;
	}

	public void setComisionesCrudRepository(ComisionesCrudRepository comisionesCrudRepository) {
		this.comisionesCrudRepository = comisionesCrudRepository;
	}

	public EmpresaCrudRepository getEmpresaCrudRepository() {
		return empresaCrudRepository;
	}

	public void setEmpresaCrudRepository(EmpresaCrudRepository empresaCrudRepository) {
		this.empresaCrudRepository = empresaCrudRepository;
	}

	public EmpleadoCrudRepository getEmpleadoCrudRepository() {
		return empleadoCrudRepository;
	}

	public void setEmpleadoCrudRepository(EmpleadoCrudRepository empleadoCrudRepository) {
		this.empleadoCrudRepository = empleadoCrudRepository;
	}

	public DatoLaboralCrudRepository getDatoLaboralCrudRepository() {
		return datoLaboralCrudRepository;
	}

	public void setDatoLaboralCrudRepository(DatoLaboralCrudRepository datoLaboralCrudRepository) {
		this.datoLaboralCrudRepository = datoLaboralCrudRepository;
	}

	public DatosPersonalesCrudRepository getDatosPersonalesCrudRepository() {
		return datosPersonalesCrudRepository;
	}

	public void setDatosPersonalesCrudRepository(DatosPersonalesCrudRepository datosPersonalesCrudRepository) {
		this.datosPersonalesCrudRepository = datosPersonalesCrudRepository;
	}

	public CargoCrudRepository getCargoCrudRepository() {
		return cargoCrudRepository;
	}

	public void setCargoCrudRepository(CargoCrudRepository cargoCrudRepository) {
		this.cargoCrudRepository = cargoCrudRepository;
	}

	public EstadoCivilCrudRepository getEstadoCivilCrudRepository() {
		return estadoCivilCrudRepository;
	}

	public void setEstadoCivilCrudRepository(EstadoCivilCrudRepository estadoCivilCrudRepository) {
		this.estadoCivilCrudRepository = estadoCivilCrudRepository;
	}

	public HijoCrudRepository getHijoCrudRepository() {
		return hijoCrudRepository;
	}

	public void setHijoCrudRepository(HijoCrudRepository hijoCrudRepository) {
		this.hijoCrudRepository = hijoCrudRepository;
	}

	public ArticuloCrudRepository getArticuloCrudRepository() {
		return articuloCrudRepository;
	}

	public void setArticuloCrudRepository(ArticuloCrudRepository articuloCrudRepository) {
		this.articuloCrudRepository = articuloCrudRepository;
	}

	public TiposIvaCrudRepository getTiposIvaCrudRepository() {
		return tiposIvaCrudRepository;
	}

	public void setTiposIvaCrudRepository(TiposIvaCrudRepository tiposIvaCrudRepository) {
		this.tiposIvaCrudRepository = tiposIvaCrudRepository;
	}

	public VentaCrudRepository getVentaCrudRepository() {
		return ventaCrudRepository;
	}

	public void setVentaCrudRepository(VentaCrudRepository ventaCrudRepository) {
		this.ventaCrudRepository = ventaCrudRepository;
	}

}
