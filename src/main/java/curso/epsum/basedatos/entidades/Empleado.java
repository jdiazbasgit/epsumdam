package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado 

{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String dni;
	private String email;
	private String telefono;
	
	@ManyToOne
	private Empresa empresa;
	@ManyToOne
	private DatoLaboral datoLaboral;
	@ManyToOne
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
