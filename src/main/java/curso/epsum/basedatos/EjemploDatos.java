package curso.epsum.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploDatos {

	public static void main(String[] args) {
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.0.125:3306/empresas?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useLegacyDatetimeCode=false&useJDBCCompliantTimezoneShift=true", "curso", "Cursocurso1;");
			conexion.setAutoCommit(false);
			Statement statement= conexion.createStatement();
			if (statement.executeUpdate("insert into estados_civiles (decripcion) values ('solterooooooo')")>0){ 
				System.out.println("grabacion realizada correctamente");
				conexion.commit();
			}
			else
				System.out.println("grabacion no relizada"); 
			
			//Class.forName("com.mysql1.cj.jdbc.Driver");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
