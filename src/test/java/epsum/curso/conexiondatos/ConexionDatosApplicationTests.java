package epsum.curso.conexiondatos;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.repositorios.CargoCrudRepository;
import epsum.curso.conexiondatos.servicios.CargoService;
import lombok.Data;

@SpringBootTest
@Data
class ConexionDatosApplicationTests {

	@Autowired
	private CargoService cargoService;
	
	@Test
	void contextLoads() {
		//System.setProperty("java.awt.headless", "false");
		Cargo cargo= new Cargo();
		cargo.setDescripcion("peripatetico-cambiado");
		cargo.setId(1502);
		getCargoService().save(cargo);
		
		//Iterable<Cargo> cargos= getCargoService().findAll();
		List<Cargo> cargos=getCargoService().getCargosQueEmpiezanPor("M%");
	
		for (Cargo cargo2 : cargos) {
			System.out.println(cargo2.getDescripcion());
		}
		
	}

}
