package epsum.curso.conexiondatos;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import epsum.curso.conexiondatos.entidades.Hijo;
import epsum.curso.conexiondatos.servicios.HijoService;
import lombok.Data;

@SpringBootTest
@Data
public class TestHijos {
	@Autowired
	private HijoService hijoService;
	
	
	//@Test
	public void alta() {
		System.setProperty("java.awt.headless", "false");
		Hijo hijo= new Hijo();
		hijo.setChicos(0);
		hijo.setChicas(0);
		getHijoService().save(hijo);
		int id=hijo.getId();
		getHijoService().deleteByID(hijo.getId());
		assertFalse(getHijoService().existById(id));
	}
	
	//@Test
	public void count() {
		assertNotEquals(getHijoService().count(), 0);
	}
	
}
