package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "cargos")
public class Cargo  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCargo;
	
	private String nombre;

}

