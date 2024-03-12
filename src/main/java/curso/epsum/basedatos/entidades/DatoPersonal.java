package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="datos_personales")
public class DatoPersonal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int hijos_id;
	
	@OneToMany
	private int estados_civiles_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHijos_id() {
		return hijos_id;
	}

	public void setHijos_id(int hijos_id) {
		this.hijos_id = hijos_id;
	}

	public int getEstados_civiles_id() {
		return estados_civiles_id;
	}

	public void setEstados_civiles_id(int estados_civiles_id) {
		this.estados_civiles_id = estados_civiles_id;
	}
	
	

}
