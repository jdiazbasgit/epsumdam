package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name="empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nombre;
	private String cif;
	public int getId() {
		return id;
	}
	public void setId(int id) {
<<<<<<< HEAD
<<<<<<< HEAD
		this.id = id;
=======
		id = id;
>>>>>>> f02da9d49ff80fef7256569bad677ee93f69a55a
=======
		id = id;
>>>>>>> f02da9d49ff80fef7256569bad677ee93f69a55a
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	

}
