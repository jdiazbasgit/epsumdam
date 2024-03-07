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

}
