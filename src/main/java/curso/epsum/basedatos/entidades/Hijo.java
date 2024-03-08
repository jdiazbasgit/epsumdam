package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< HEAD
@Entity 
@Table(name = "hijos")
public class Hijo {
 
=======


@Entity
@Table (name = "hijos")
public class Hijo  {
	
>>>>>>> 9053d2f420f02c72154535015f1368d2dd9cc340
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idHijo;

	private int chicos;
	
	private int chicas;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		return idHijo;
	}

	public int getChicos() {
		return chicos;
	}

	public void setChicos(int chicos) {
		this.chicos = chicos;
	}

	public int getChicas() {
		return chicas;
	}

	public void setChicas(int chicas) {
		this.chicas = chicas;
	}
}
