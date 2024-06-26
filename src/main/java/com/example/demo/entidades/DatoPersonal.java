package com.example.demo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the datos_personales database table.
 * 
 */
@Entity
@Table(name="datos_personales")
@NamedQuery(name="DatosPersonale.findAll", query="SELECT d FROM DatoPersonal d")
public class DatoPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to EstadosCivile
	@ManyToOne
	@JoinColumn(name="estados_civiles_id")
	private EstadoCivil estadosCivile;

	//bi-directional many-to-one association to Hijo
	@ManyToOne
	@JoinColumn(name="hijos_id")
	private Hijo hijo;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="datosPersonale")
	private List<Empleado> empleados;

	public DatoPersonal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EstadoCivil getEstadosCivile() {
		return this.estadosCivile;
	}

	public void setEstadosCivile(EstadoCivil estadosCivile) {
		this.estadosCivile = estadosCivile;
	}

	public Hijo getHijo() {
		return this.hijo;
	}

	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setDatosPersonale(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setDatosPersonale(null);

		return empleado;
	}

}