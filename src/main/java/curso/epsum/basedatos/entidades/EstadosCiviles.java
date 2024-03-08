package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estados_civiles")
public class EstadosCiviles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	private String DECRIPCION;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDECRIPCION() {
		return DECRIPCION;
	}

	public void setDECRIPCION(String dECRIPCION) {
		DECRIPCION = dECRIPCION;
	}
	
}
