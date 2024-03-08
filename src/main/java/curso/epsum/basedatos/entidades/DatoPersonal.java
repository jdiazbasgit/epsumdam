package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="datos_personales")
public class DatoPersonal
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	@ManyToOne
	private Hijo hijo;
	
	@ManyToOne
	private  EstadoCivil EstadoCivil;
	

	public Hijo getHijo() {
		return hijo;
	}

	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}

	public EstadoCivil getEstadoCivil() {
		return EstadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		EstadoCivil = estadoCivil;
	}

}
