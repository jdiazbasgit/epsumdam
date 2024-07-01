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

	

}