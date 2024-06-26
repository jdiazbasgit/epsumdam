package com.example.demo.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comisiones database table.
 * 
 */
@Entity
@Table(name="comisiones")
@NamedQuery(name="Comisione.findAll", query="SELECT c FROM Comision c")
public class Comision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int comision;

	private int maximo;

	private int minimo;

	public Comision() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getComision() {
		return this.comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	public int getMaximo() {
		return this.maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public int getMinimo() {
		return this.minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

}