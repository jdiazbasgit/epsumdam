package curso.epsum.basedatos.entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")

public class Empresas {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		private String nombreempresa;
		
		private String ubicacion;
		
		
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
