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
 * The persistent class for the datos_laborales database table.
 * 
 */
@Entity
@Table(name="datos_laborales")
@NamedQuery(name="DatosLaborale.findAll", query="SELECT d FROM DatoLaboral d")
public class DatoLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int salario;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="cargos_id")
	private Cargo cargo;

	

	public DatoLaboral() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalario() {
		return this.salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	

}