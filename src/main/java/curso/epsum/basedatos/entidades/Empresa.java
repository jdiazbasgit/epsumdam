package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresa")

public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int descripcion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}


}
