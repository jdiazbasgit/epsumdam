package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Table(name="datos_personales")
public class DatoPersonal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="hijos_id")
	private Hijo hijo;
	@ManyToOne
	@JoinColumn(name="estados_civiles_id")
	private EstadoCivil estadoCivil;
	
}
