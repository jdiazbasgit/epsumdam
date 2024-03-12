package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="empleados")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEmpleado;
	private String nombre;
	private String dni;
	private String email;
	private String tlf;
	
	@ManyToOne
	@JoinColumn(name="idEmpresa")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="idDatoPersonal")
	private DatoPersonal datosPersonal;
	
	@ManyToOne
	@JoinColumn(name="idDatoLaboral")
	private DatoLaboral datoLaboral;
	
}
