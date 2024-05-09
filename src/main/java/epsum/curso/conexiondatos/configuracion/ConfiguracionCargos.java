 package epsum.curso.conexiondatos.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.servicios.CargoService;
import epsum.curso.conexiondatos.ventanas.PanelCargos;
import lombok.Data;

@Configuration
@Data
public class ConfiguracionCargos {

	@Autowired
	private CargoService cargoService;
	
	public Object[] cabecerasCargos() {
		Object[] cabeceras = { "ID", "DESCRIPCION" };
		return  cabeceras;
	}
	public Object[][] datosCargos() {
		List<Cargo> cargos = (List<Cargo>) cargoService.findAll();
		Object[][] datos = new Object[(int) cargoService.count()][2];
		int i = 0;
		for (Cargo cargo : cargos) {
			datos[i][0] = String.valueOf(cargo.getId());
			datos[i][1] = cargo.getDescripcion();
			i++;
		}
		return datos;
	}
	
	
	@Bean
	public PanelCargos getPanelCargos() {
		return new PanelCargos(cabecerasCargos(),datosCargos(),"CARGOS");
	}

}
