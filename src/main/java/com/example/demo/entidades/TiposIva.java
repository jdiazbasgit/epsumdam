package com.example.demo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipos_iva database table.
 * 
 */
@Entity
@Table(name="tipos_iva")
@NamedQuery(name="TiposIva.findAll", query="SELECT t FROM TiposIva t")
public class TiposIva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int iva;

	

	public TiposIva() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIva() {
		return this.iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	
	


}