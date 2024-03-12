package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "datos_personales")
public class DatoPersonal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDatoPersonal;
	

	@ManyToOne
	private Hijo hijo;
	
	@ManyToOne
	private EstadoCivil estadoCivil;
	
}