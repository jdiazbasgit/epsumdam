package epsum.curso.conexiondatos.entidades;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "datos_laborales")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DatoLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int salario;
	
	@ManyToOne
	@JoinColumn(name = "cargos_id")
	private Cargo cargo;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getCargo().getDescripcion()+ " - " + getSalario();
	}
	
}
