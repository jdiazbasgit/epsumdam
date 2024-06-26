package com.example.demo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the articulos database table.
 * 
 */
@Entity
@Table(name="articulos")
@NamedQuery(name="Articulo.findAll", query="SELECT a FROM Articulo a")
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	private int precio;

	//bi-directional many-to-one association to TiposIva
	@ManyToOne
	@JoinColumn(name="tipo_iva_id")
	private TiposIva tiposIva;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="articulo")
	private List<Venta> ventas;

	public Articulo() {
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

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public TiposIva getTiposIva() {
		return this.tiposIva;
	}

	public void setTiposIva(TiposIva tiposIva) {
		this.tiposIva = tiposIva;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setArticulo(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setArticulo(null);

		return venta;
	}

}