package curso.epsum.basedatos.entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import jakarta.annotation.Generated;

@Entity
@Table(name = "datos_laborales")
public class DatoLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int chicos;
	
	private int chicas;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
