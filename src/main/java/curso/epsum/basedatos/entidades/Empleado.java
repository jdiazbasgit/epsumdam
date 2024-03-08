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
	private String DNI;
	private String EMAIL;
	private String Tel;
	
	@ManyToOne
	private Empresa Empresa;
	@ManyToOne
	private DatoLaboral DatoLaboral;
	@ManyToOne
	private DatoPersonal DatoPersonal;
	
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
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public Empresa getEmpresa() {
		return Empresa;
	}
	public void setEmpresa(Empresa empresa) {
		Empresa = empresa;
	}
	public DatoLaboral getDatoLaboral() {
		return DatoLaboral;
	}
	public void setDatoLaboral(DatoLaboral datoLaboral) {
		DatoLaboral = datoLaboral;
	}
	public DatoPersonal getDatoPersonal() {
		return DatoPersonal;
	}
	public void setDatoPersonal(DatoPersonal datoPersonal) {
		DatoPersonal = datoPersonal;
	}

}
