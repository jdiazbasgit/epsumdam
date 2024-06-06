package epsum.curso.conexiondatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table (name = "hijos")
@Getter
@Setter
public class Hijo  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int chicos;
	  
	private int chicas; 

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getChicos()+" - "+getChicas();	
	}
}
