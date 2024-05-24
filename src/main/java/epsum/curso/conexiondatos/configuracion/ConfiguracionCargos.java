package epsum.curso.conexiondatos.configuracion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
		Connection conexion=null;
		Object[] cabeceras=new Object[2] ;
		try {
			 conexion= DriverManager.getConnection("jdbc:mysql://192.168.0.126:3306/empresas?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC","curso","Cursocurso1;");
			Statement st=conexion.createStatement();
			ResultSet rs= st.executeQuery("select * from cargos");
			ResultSetMetaData rsmd= rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++)
			{
				cabeceras[i]=rsmd.getColumnName(i+1);
			}
			//Object[] cabeceras = { "ID", "DESCRIPCION" };
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
