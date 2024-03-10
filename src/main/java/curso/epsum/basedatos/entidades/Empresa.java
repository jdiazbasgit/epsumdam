package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "empresas")
public class Empresa  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEmpresa;
	
	private String nombre;
	
	private String CIF;

	public int getIdEmpresa() {
		return idEmpresa;
	}
 	public void setId(int id) {
			this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String CIF) {
		this.CIF = CIF;
	}


}
