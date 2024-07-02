package com.example.demo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
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

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private GregorianCalendar fechaAlta;

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private GregorianCalendar fechaBaja;

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private GregorianCalendar fechaNacimiento;

	private String nombre;

	//bi-directional many-to-one association to DatosLaborale
	@ManyToOne
	@JoinColumn(name="datos_laborales_id")
	private DatoLaboral datoLaboral;

	//bi-directional many-to-one association to DatosPersonale
	@ManyToOne
	@JoinColumn(name="datos_personales_id")
	private DatoPersonal datoPersonal;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="empresas_id")
	private Empresa empresa;

	

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

	

	

	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(GregorianCalendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public GregorianCalendar getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(GregorianCalendar fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public DatoLaboral getDatoLaboral() {
		return datoLaboral;
	}

	public void setDatoLaboral(DatoLaboral datoLaboral) {
		this.datoLaboral = datoLaboral;
	}

	public DatoPersonal getDatoPersonal() {
		return datoPersonal;
	}

	public void setDatoPersonal(DatoPersonal datoPersonal) {
		this.datoPersonal = datoPersonal;
	}

	

	

}