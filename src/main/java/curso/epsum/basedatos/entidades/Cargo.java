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
@Table(name = "cargos")

	
public class Cargo {
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
@Table (name="cargos")
public class Cargo 
{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int ID;
		private int descripcion;
		public int getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(int descripcion) {
			this.descripcion = descripcion;
		}
	


>>>>>>> f1ce88d791779a31cd8d0c90adf14d34e0645813
}
