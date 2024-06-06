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
import epsum.curso.conexiondatos.servicios.HijoService;
import epsum.curso.conexiondatos.servicios.DatosPersonalesService;
import epsum.curso.conexiondatos.servicios.EstadoCivilService;
import epsum.curso.conexiondatos.ventanas.PanelCargos;
import epsum.curso.conexiondatos.ventanas.PanelDatosPersonales;
import lombok.Data;

@Configuration
@Data
public class ConfiguracionDatosPersonales {

	@Autowired
	private DatosPersonalesService datosPersonalesService;
	@Autowired
	private HijoService hijoService;
	@Autowired
	private EstadoCivilService estadoCivilService;
	
	public String[] cabecerasDatosPersonales() {
		String[] cabeceras = { "ID", "ESTADOCIVIL", "NUMERO HIJOS" };
		return  cabeceras;
	}
	public Object[][] datosDatosPersonales() {
		List<DatoPersonal> datosPersonales = (List<DatoPersonal>) datosPersonalesService.findAll();
		Object[][] datos = new Object[(int) datosPersonalesService.count()][3];
		int i = 0;
		for (DatoPersonal datoPersonal : datosPersonales) {
			Hijo[] hijos=((List<Hijo>)getHijoService().findAll()).toArray(new Hijo[0]);
			JComboBox<Hijo> comboBoxHijo = new JComboBox<Hijo>(hijos);
			EstadoCivil[] estadosCiviles=((List<EstadoCivil>)getEstadoCivilService().findAll()).toArray(new EstadoCivil[0]);
			JComboBox<EstadoCivil> comboBoxEstadoCivil = new JComboBox<EstadoCivil>(estadosCiviles);
			datos[i][0] = String.valueOf(datoPersonal.getId());
			for (int j=0;j<hijos.length;j++) {
				if(hijos[j].getId()==datoPersonal.getHijo().getId()) {
					comboBoxHijo.setSelectedIndex(j);
				}
			}
			for (int x=0;x<estadosCiviles.length;x++) {
				if(estadosCiviles[x].getId()==datoPersonal.getEstadoCivil().getId()) {
					comboBoxEstadoCivil.setSelectedIndex(x);
				}
			}
			
			datos[i][1]=comboBoxEstadoCivil;
			datos[i][2]=comboBoxHijo;
			
		}
		return datos;
	}
	
	
	@Bean
	public PanelDatosPersonales panelDatosPersonales() {
		PanelDatosPersonales datosPersonales= new PanelDatosPersonales(cabecerasDatosPersonales(), datosDatosPersonales(), "DATOS PERSONALES");
		return datosPersonales;
	}

}
