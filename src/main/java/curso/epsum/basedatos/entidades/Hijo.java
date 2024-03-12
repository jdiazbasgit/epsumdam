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
@Table(name = "hijos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hijo {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int chicos;
	
	private int chicas;
	
	
}
