package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "empresas")
public class Empresa  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEmpresa;
	
	private String nombre;
	
	private String cif;
	
}

	
