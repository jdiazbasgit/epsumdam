package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class empleado {

	private int id;
	private String nombre;
	private String dni;
	private String email;
	private String telefono;
	private int empresas_id;
	private int datos_personales_id;
	private int datos_laborales_id;
	
}
