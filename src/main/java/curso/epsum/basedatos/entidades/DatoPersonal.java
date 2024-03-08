package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "datos_personales")
public class DatoPersonal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "hijos_id")
	private Hijo hijo;

	@ManyToOne
	@JoinColumn(name = "estados_civiles_id")
	private EstadoCivil estadocivil;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hijo getHijo() {
		return hijo;
	}

	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}

	public EstadoCivil getEstadocivil() {
		return estadocivil;
	}

	public void setEstado_civil(EstadoCivil estadocivil) {
		this.estadocivil = estadocivil;
	}
	
	
}
