package curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="datos_laborales")
public class DatoLaboral {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

private int salario;

@OneToMany
private int cargos_id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
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
