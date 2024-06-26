package com.example.demo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellidos;

	private String dni;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	//bi-directional many-to-one association to DatosLaborale
	@ManyToOne
	@JoinColumn(name="datos_laborales_id")
	private DatoLaboral datosLaborale;

	//bi-directional many-to-one association to DatosPersonale
	@ManyToOne
	@JoinColumn(name="datos_personales_id")
	private DatoPersonal datosPersonale;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empresas_id")
	private Empresa empresa;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="empleado")
	private List<Venta> ventas;

	public Empleado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DatoLaboral getDatosLaborale() {
		return this.datosLaborale;
	}

	public void setDatosLaborale(DatoLaboral datosLaborale) {
		this.datosLaborale = datosLaborale;
	}

	public DatoPersonal getDatosPersonale() {
		return this.datosPersonale;
	}

	public void setDatosPersonale(DatoPersonal datosPersonale) {
		this.datosPersonale = datosPersonale;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setEmpleado(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setEmpleado(null);

		return venta;
	}

}