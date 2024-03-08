package curso.epsum.basedatos.entidades;

<<<<<<< HEAD


=======
>>>>>>> f1ce88d791779a31cd8d0c90adf14d34e0645813
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
<<<<<<< HEAD
@Table(name = "empresas")

public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String Nombre;
	private String CIF;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
=======
@Table(name="empresas")
public class Empresa 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String CIF;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
>>>>>>> f1ce88d791779a31cd8d0c90adf14d34e0645813
	}
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}

}
