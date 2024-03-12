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
	
	
	public int getId() {
		return id;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public DatoLaboral getDatoLaboral() {
		return datoLaboral;
	}
	public void setDatoLaboral(DatoLaboral datoLaboral) {
		this.datoLaboral = datoLaboral;
	}
	public DatoPersonal getDatoPersonal() {
		return datoPersonal;
	}
	public void setDatoPersonal(DatoPersonal datoPersonal) {
		this.datoPersonal = datoPersonal;
	}

	
	


}
