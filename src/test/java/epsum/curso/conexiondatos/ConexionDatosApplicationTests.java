package epsum.curso.conexiondatos;

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
		
		Iterable<Cargo> cargo= getCargoService().findAll();
	
		for (Cargo cargo2 : cargo) {
			System.out.println(cargo2.getDescripcion());
		}
		
	}

}
