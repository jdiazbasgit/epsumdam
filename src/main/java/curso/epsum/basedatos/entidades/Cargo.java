package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="cargos")
public class Cargo 
{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String descripcion;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	


}
