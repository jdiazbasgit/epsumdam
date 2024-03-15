package epsum.curso.conexiondatos.entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "datos_laborales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatoLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int salario;
	
	@ManyToOne
	//@JoinColumn(name = "idCargo")
	private Cargo cargo;

	
}
