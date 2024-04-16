package epsum.curso.conexiondatos;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.servicios.CargoService;
import lombok.Data;

@SpringBootTest
@Data
public class TestCargos {
	@Autowired
	private CargoService cargoService;
	
	
	@Test
	public void alta() {
		System.setProperty("java.awt.headless", "false");
		Cargo cargo= new Cargo();
		cargo.setDescripcion("prueba test");
		getCargoService().save(cargo);
		getCargoService().deleteById(cargo.getId());
	}
	
	

}
