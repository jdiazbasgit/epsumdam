package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "datos_laborales")
public class DatoLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDatoLaboral;
	
	private double salario;
	
	@ManyToOne
	@JoinColumn(name = "idCargo")
	private Cargo cargo;
	
	public int getIdDatoLaboral() {
		return idDatoLaboral;
	}

	public void setIdDatoLaboral(int idDatoLaboral) {
		this.idDatoLaboral = idDatoLaboral;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	
	
}