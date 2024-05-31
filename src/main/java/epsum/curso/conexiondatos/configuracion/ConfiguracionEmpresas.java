package epsum.curso.conexiondatos.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.ventanas.PanelEmpresas;
import lombok.Data;

@Configuration
@Data

public class ConfiguracionEmpresas {

	@Autowired
	private EmpresaService empresaService;
	
	public String[] cabecerasEmpresas() {
		String[] cabeceras = {"ID", "NOMBRE", "CIF"};
		return cabeceras;
	}
	
	public Object[][] datosEmpresas(){
		List<Empresa> empresas = (List<Empresa>) empresaService.findAll();
		Object[][] datos = new Object[(int) empresaService.count()][3];
		int i = 0;
		for (Empresa empresa : empresas) {
			datos[i][0] = String.valueOf(empresa.getId());
			datos[i][1] = empresa.getNombre();
			datos[i][2] = empresa.getCif();
			i++;
		}
		return datos;
	}
	
	@Bean
	public PanelEmpresas getPanelEmpresas() {
		return new PanelEmpresas(cabecerasEmpresas(), datosEmpresas(), "EMPRESAS");
	}
}
