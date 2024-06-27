package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@Data
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
	@GetMapping("artculos")
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
	@PostMapping("grabar")
	public Object grabar(@RequestBody Object dato) {

		if (dato instanceof Empresa)
			return empresaCrudRepository.save((Empresa) dato);
		if (dato instanceof Empleado)
			return empleadoCrudRepository.save((Empleado) dato);
		if (dato instanceof DatoLaboral)
			return datoLaboralCrudRepository.save((DatoLaboral) dato);
		if (dato instanceof DatoPersonal)
			return datosPersonalesCrudRepository.save((DatoPersonal) dato);
		if (dato instanceof Cargo)
			return cargoCrudRepository.save((Cargo) dato);
		if (dato instanceof EstadoCivil)
			return estadoCivilCrudRepository.save((EstadoCivil) dato);
		if (dato instanceof Hijo)
			return hijoCrudRepository.save((Hijo) dato);
		if (dato instanceof Articulo)
			return articuloCrudRepository.save((Articulo) dato);
		if (dato instanceof Venta)
			return ventaCrudRepository.save((Venta) dato);
		if (dato instanceof Comision)
			return comisionesCrudRepository.save((Comision) dato);
		if (dato instanceof TiposIva)
			return tiposIvaCrudRepository.save((TiposIva) dato);
		return null;
		
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("borrar")
	public void borrar(@RequestBody Object dato) {

		if (dato instanceof Empresa)
			 empresaCrudRepository.delete((Empresa) dato);
		if (dato instanceof Empleado)
			 empleadoCrudRepository.delete((Empleado) dato);
		if (dato instanceof DatoLaboral)
			 datoLaboralCrudRepository.delete((DatoLaboral) dato);
		if (dato instanceof DatoPersonal)
			 datosPersonalesCrudRepository.delete((DatoPersonal) dato);
		if (dato instanceof Cargo)
			 cargoCrudRepository.delete((Cargo) dato);
		if (dato instanceof EstadoCivil)
			 estadoCivilCrudRepository.delete((EstadoCivil) dato);
		if (dato instanceof Hijo)
			 hijoCrudRepository.delete((Hijo) dato);
		if (dato instanceof Articulo)
			 articuloCrudRepository.delete((Articulo) dato);
		if (dato instanceof Venta)
			 ventaCrudRepository.delete((Venta) dato);
		if (dato instanceof Comision)
			 comisionesCrudRepository.delete((Comision) dato);
		if (dato instanceof TiposIva)
			 tiposIvaCrudRepository.delete((TiposIva) dato);
		
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("srvidor")
	public Comision getComisiones1(@RequestBody Comision comision) {
		return  comisionesCrudRepository.save(comision);
	}
	

	@CrossOrigin(origins = "*")
	@PostMapping("servidor/{user}/{pass}")
	public void servidor(@PathVariable String user, @PathVariable String pass) {
		System.out.println(user+" - "+pass);
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

}
