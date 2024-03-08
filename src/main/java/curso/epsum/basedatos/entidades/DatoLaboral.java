package main.java.curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="datos_laborales")
public class DatoLaboral 
{
	private int Id;
	private int salario;
	private int cargos_id;
	
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
	public int getCargos_id() {
		return cargos_id;
	}
	public void setCargos_id(int cargos_id) {
		this.cargos_id = cargos_id;
	}

}
