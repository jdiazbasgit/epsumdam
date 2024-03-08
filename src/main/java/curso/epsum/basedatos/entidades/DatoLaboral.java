package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
<<<<<<< HEAD
import javax.persistence.Table;

import curso.epsum.basedatos.entidades.Cargo;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
@Table(name="datos_laborales")
public class DatoLaboral 
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int Id;
	private int salario;
	@ManyToOne
	private Cargo cargos_id;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}

	
}
=======
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import jakarta.annotation.Generated;

@Entity
@Table(name = "datos_laborales")
public class DatoLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int salario;
	
	@ManyToOne
	//@JoinColumn(name = "idCargo")
	private Cargo cargo;
	
}
>>>>>>> 836e0d4d57805cba2a348bf6435bce08fd37e965
