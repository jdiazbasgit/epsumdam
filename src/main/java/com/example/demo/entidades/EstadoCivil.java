package com.example.demo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estados_civiles database table.
 * 
 */
@Entity
@Table(name="estados_civiles")
@NamedQuery(name="EstadosCivile.findAll", query="SELECT e FROM EstadoCivil e")
public class EstadoCivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	
	public EstadoCivil() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}