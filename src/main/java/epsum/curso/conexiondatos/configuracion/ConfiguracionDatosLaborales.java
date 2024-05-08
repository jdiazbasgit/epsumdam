 package epsum.curso.conexiondatos.configuracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.ventanas.PanelDatosLaborales;
import epsum.curso.conexiondatos.servicios.DatoLaboralService;
import lombok.Data;

@Data
@Configuration
public class ConfiguracionDatosLaborales {

	@Autowired
	private DatoLaboralService datoLaboralService;
	
	public Object[] cabecerasDatosLaborales() {
		Object[] cabeceras = { "ID", "SALARIO", "CARGO" };
		return cabeceras;
	}
	public Object[][] datosDatosLaborales(){
		List<DatoLaboral> datosLaborales = (List<DatoLaboral>) datoLaboralService.findAll();
		Object[][] datos = new Object[(int) datoLaboralService.count()][3];
		int i = 0;
		for (DatoLaboral datoLaboral : datosLaborales) {
			datos[i][0] = String.valueOf(datoLaboral.getId());
			datos[i][1] = datoLaboral.getSalario();
			datos[i][2] = datoLaboral.getCargo().getDescripcion();

			i++;

		}
		return datos;
		
	}
	
	@Bean
	public PanelDatosLaborales getPanelDatosLaborales() {
		return new PanelDatosLaborales(cabecerasDatosLaborales(), datosDatosLaborales(), "DATOS LABORALES");
	}
}
