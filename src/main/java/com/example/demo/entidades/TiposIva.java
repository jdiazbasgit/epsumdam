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

	//bi-directional many-to-one association to Articulo
	@OneToMany(mappedBy="tiposIva")
	private List<Articulo> articulos;

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

	public List<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Articulo addArticulo(Articulo articulo) {
		getArticulos().add(articulo);
		articulo.setTiposIva(this);

		return articulo;
	}

	public Articulo removeArticulo(Articulo articulo) {
		getArticulos().remove(articulo);
		articulo.setTiposIva(null);

		return articulo;
	}

}