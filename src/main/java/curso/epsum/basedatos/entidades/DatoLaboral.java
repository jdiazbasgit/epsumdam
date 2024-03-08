package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Table(name="datos_laborales")
public class DatoLaboral {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private int salario;
	private int cargos_id;
	
	@ManyToOne
	@JoinColumn(name="cargos_id")
	private Cargo cargo;
	

}
