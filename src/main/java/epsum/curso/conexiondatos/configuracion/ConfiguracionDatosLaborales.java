 package epsum.curso.conexiondatos.configuracion;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.ventanas.PanelDatosLaborales;
import epsum.curso.conexiondatos.servicios.CargoService;
import epsum.curso.conexiondatos.servicios.DatoLaboralService;
import lombok.Data;

@Data
@Configuration
public class ConfiguracionDatosLaborales {

	@Autowired
	private DatoLaboralService datoLaboralService;
	@Autowired
	private CargoService cargoService;
	private JComboBox<Cargo> jComboBoxCargo;

	public Object[] cabecerasDatosLaborales() {
		Object[] cabeceras = { "ID", "SALARIO", "CARGO" };
		return cabeceras;
	}
	public Object[][] datosDatosLaborales(){
		List<DatoLaboral> datosLaborales = (List<DatoLaboral>) datoLaboralService.findAll();
		Object[][] datos = new Object[(int) getDatoLaboralService().count()][3];
		int i = 0;
		for (DatoLaboral datoLaboral : datosLaborales) {
			
			Cargo[] cargos=((List<Cargo>)getCargoService().findAll()).toArray(new Cargo[0]);
	        JComboBox<Cargo> comboBoxCargo = new JComboBox<Cargo>(cargos);
			datos[i][0] = String.valueOf(datoLaboral.getId());
			datos[i][1] = String.valueOf(datoLaboral.getSalario());
			for(int j=0;j<cargos.length;j++) {
				if(cargos[j].getId()==datoLaboral.getCargo().getId())
					comboBoxCargo.setSelectedIndex(j);
			}
			
			
			//comboBoxCargo.setSelectedItem(datoLaboral.getCargo());
			datos[i][2] = comboBoxCargo;

			i++;

		}
		return datos;
		
	}
	
	@Bean
	public PanelDatosLaborales getPanelDatosLaborales() {
		PanelDatosLaborales datosLaborales= new PanelDatosLaborales(cabecerasDatosLaborales(), datosDatosLaborales(), "DATOS LABORALES");
		//datosLaborales.getTabla().getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jComboBoxCargo));

		return datosLaborales; 
	}
}
