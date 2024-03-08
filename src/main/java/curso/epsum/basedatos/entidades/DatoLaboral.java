package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
