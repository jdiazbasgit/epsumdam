package curso.epsum.basedatos.entidades;

<<<<<<< HEAD
=======

>>>>>>> d803d3d76993e8368e3a2b16473e03786903e0fe
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
	
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}
	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String descripcion) {
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
	



>>>>>>> d803d3d76993e8368e3a2b16473e03786903e0fe

}
