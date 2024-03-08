package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
<<<<<<< HEAD
@Table(name = "estadosciviles")
public class EstadoCivil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 

	
=======
@Table(name ="estados_civiles")
public class EstadoCivil 
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String decripcion;
	
	
	public String getDecripcion() {
		return decripcion;
	}
	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}

>>>>>>> f1ce88d791779a31cd8d0c90adf14d34e0645813
}
