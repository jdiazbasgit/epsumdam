package epsum.curso.conexiondatos.entidades;

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
@Table(name = "datos_personales")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DatoPersonal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "hijos_id")
	private Hijo hijo;

	@ManyToOne
	@JoinColumn(name = "estados_civiles_id")
	private EstadoCivil estadoCivil;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getEstadoCivil().getDescripcion()+ " - " + getHijo().getChicos()+ " - " + getHijo().getChicas();
		}

}
