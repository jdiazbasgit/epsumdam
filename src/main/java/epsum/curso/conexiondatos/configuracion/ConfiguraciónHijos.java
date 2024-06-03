package epsum.curso.conexiondatos.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.conexiondatos.entidades.Hijo;
import epsum.curso.conexiondatos.ventanas.PanelHijos;
import epsum.curso.conexiondatos.servicios.DatoLaboralService;
import epsum.curso.conexiondatos.servicios.HijoService;
import lombok.Data;

@Data
@Configuration
public class ConfiguraciónHijos {

	@Autowired
	private HijoService hijoService;
	
	public String[] cabecerasHijos() {
		String[] cabeceras = {"ID", "CHICOS", "CHICAS"};
		return cabeceras;
	}
	public Object[][] datosHijos(){
		List<Hijo> hijos = (List<Hijo>) getHijoService().findAll();
		Object[][] datos = new Object[(int) getHijoService().count()][3];
		int i = 0;
		for (Hijo c : hijos) {
			datos[i][0] = String.valueOf(c.getId());
			datos[i][1] = String.valueOf(c.getChicos());
			datos[i][2] = String.valueOf(c.getChicas());
			i++;
		}
		return datos;
		
	}
	
	@Bean
	public PanelHijos getPanelHijos() {
		return new PanelHijos(cabecerasHijos(), datosHijos(), "HIJOS");
	}
}
