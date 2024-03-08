package curso.epsum.basedatos.entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity


@Table (name = "cargos")
public class Cargo  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCargo;
	
	private String nombre;

	public int getIdCargo() {
		return idCargo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
