package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nombre;
	
	private String dni;
	
	private String email;
	
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "empresas_id")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "datos_personales_id")
	private Dato_personal dato_personal;
	
	@ManyToOne
	@JoinColumn(name = "datos_laborales_id")
	private Dato_laboral dato_laboral;
}
