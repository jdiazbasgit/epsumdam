package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public DatoPersonal getDatosPersonal() {
		return datosPersonal;
	}

	public void setDatosPersonal(DatoPersonal datosPersonal) {
		this.datosPersonal = datosPersonal;
	}

	public DatoLaboral getDatoLaboral() {
		return datoLaboral;
	}

	public void setDatoLaboral(DatoLaboral datoLaboral) {
		this.datoLaboral = datoLaboral;
	}


}
