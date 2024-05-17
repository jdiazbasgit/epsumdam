package epsum.curso.conexiondatos.configuracion;

import java.util.List;

import javax.swing.JComboBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.entidades.Hijo;
import epsum.curso.conexiondatos.servicios.CargoService;
import epsum.curso.conexiondatos.servicios.DatosPersonalesService;
import epsum.curso.conexiondatos.ventanas.PanelCargos;
import epsum.curso.conexiondatos.ventanas.PanelDatosPersonales;
import lombok.Data;

@Configuration
@Data
public class ConfiguracionDatosPersonales {

	@Autowired
	private DatosPersonalesService datosPersonalesService;
	
	public Object[] cabecerasDatosPersonales() {
		Object[] cabeceras = { "ID", "DESCRIPCION", "NUMERO HIJOS" };
		return  cabeceras;
	}
	public Object[][] datosDatosPersonales() {
		List<DatoPersonal> datosPersonales = (List<DatoPersonal>) datosPersonalesService.findAll();
		Object[][] datos = new Object[(int) datosPersonalesService.count()][3];
		int i = 0;
		Hijo[] hijos = {new Hijo(0,1,1),new Hijo(0,2,1), new Hijo(0,1,2)};
		EstadoCivil [] estadosCiviles = {new EstadoCivil (1,"Casado"), new EstadoCivil(2,"Soltero"), new EstadoCivil(3,"Casado)")};
		JComboBox<Hijo> jComboBox = new JComboBox<>(hijos);
		JComboBox <EstadoCivil> jComboBox1 = new JComboBox<> (estadosCiviles);
		
		for (DatoPersonal datoPersonal : datosPersonales) {
			
			datos[i][0] = String.valueOf(datoPersonal.getId());
			datos[i][1] = jComboBox1;
			//datos[i][2] = datoPersonal.getHijo().getChicos() + " - " + datoPersonal.getHijo().getChicas();
			datos[i][2]= jComboBox;
			i++;
			
		}
		return datos;
	}
	
	
	@Bean
	public PanelDatosPersonales panelDatosPersonales() {
		return new PanelDatosPersonales(cabecerasDatosPersonales(),datosDatosPersonales(),"DatosPersonales");
	}

}
