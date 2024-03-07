package main.java.curso.epsum.basedatos.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="Hijos")
public class Hijo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int chicos;
	
	private int chicas;

	public int getChicos() {
		return chicos;
	}

	public void setChicos(int chicos) {
		this.chicos = chicos;
	}

	public int getChicas() {
		return chicas;
	}

	public void setChicas(int chicas) {
		this.chicas = chicas;
	}
}
