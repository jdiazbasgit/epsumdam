package epsum.curso.conexiondatos.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.servicios.CargoService;
import epsum.curso.conexiondatos.servicios.EstadoCivilService;
import epsum.curso.conexiondatos.ventanas.PanelCargos;
import epsum.curso.conexiondatos.ventanas.PanelEstadosCiviles;
import lombok.Data;

@Configuration
@Data
public class ConfiguracionEstadosCiviles {

	@Autowired
	private EstadoCivilService estadoCivilService;
	
	public String[] cabecerasEstadosCiviles() {
		String[] cabeceras = { "ID", "DESCRIPCION" };
		return  cabeceras;
	}
	public Object[][] datosEstadosCiviles() {
		List<EstadoCivil> estadosCiviles = (List<EstadoCivil>) estadoCivilService.findAll();
		Object[][] datos = new Object[(int) estadoCivilService.count()][2];
		int i = 0;
		for (EstadoCivil estadoCivil : estadosCiviles) {
			datos[i][0] = String.valueOf(estadoCivil.getId());
			datos[i][1] = estadoCivil.getDescripcion();
			i++;
		}
		return datos;
	}
	
	
	@Bean
	public PanelEstadosCiviles getPanelEstadosCiviles() {
		return new PanelEstadosCiviles(cabecerasEstadosCiviles(),datosEstadosCiviles(),"ESTADOS CIVILES");
	}

}
