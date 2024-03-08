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
	private int idDatoPersonal;
	

	@ManyToOne
	@JoinColumn(name = "idHijo")
	private Hijo hijo;
	
	@ManyToOne
	@JoinColumn(name = "idEstadoCivil")
	private EstadoCivil estadoCivil;
	

	public int getIdDatoPersonal() {
		return idDatoPersonal;
	}


	public void setIdDatoPersonal(int idDatoPersonal) {
		this.idDatoPersonal = idDatoPersonal;
	}


	public Hijo getHijo() {
		return hijo;
	}


	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}


	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}