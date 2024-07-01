package com.example.demo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hijos database table.
 * 
 */
@Entity
@Table(name="hijos")
@NamedQuery(name="Hijo.findAll", query="SELECT h FROM Hijo h")
public class Hijo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int chicas;

	private int chicos;

	

	public Hijo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChicas() {
		return this.chicas;
	}

	public void setChicas(int chicas) {
		this.chicas = chicas;
	}

	public int getChicos() {
		return this.chicos;
	}

	public void setChicos(int chicos) {
		this.chicos = chicos;
	}

	

}