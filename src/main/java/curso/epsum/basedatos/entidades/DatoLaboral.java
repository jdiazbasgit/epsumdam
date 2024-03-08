package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DatoLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int salario;
	private Cargo cargo;
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
