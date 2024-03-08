package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

}
