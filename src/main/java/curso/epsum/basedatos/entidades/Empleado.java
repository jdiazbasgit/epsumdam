package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Table(name="empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String nombre;
	private String dni;
	private String email;
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="empresas_id")
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(name="datos_laborales_id")
	private DatoLaboral datoLaboral;
	@ManyToOne
	@JoinColumn(name="datos_personales_id")
	private DatoPersonal datoPersonal;
	

	
	


}
