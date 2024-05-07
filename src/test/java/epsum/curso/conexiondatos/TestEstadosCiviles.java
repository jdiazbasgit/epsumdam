package epsum.curso.conexiondatos;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.servicios.EstadoCivilService;

import lombok.Data;

@SpringBootTest
@Data
public class TestEstadosCiviles {
	@Autowired
	private EstadoCivilService estadoCivilService;
	
	@Test
	public void alta() {
		System.setProperty("java.awt.headless", "false");
		EstadoCivil estadoCivil= new EstadoCivil();
		estadoCivil.setDescripcion("PRUEBA TEST 2");
		getEstadoCivilService().save(estadoCivil);		
		int id = estadoCivil.getId();
		getEstadoCivilService().deleteById(estadoCivil.getId());
		assertFalse(getEstadoCivilService().existById(id));		
	}	
		
	@Test
	public void count() {
		assertNotEquals(getEstadoCivilService().count(), 0);
	}
	

}
