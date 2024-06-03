package epsum.curso.conexiondatos;

import java.awt.Frame;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.yaml.snakeyaml.comments.CommentLine;

import epsum.curso.conexiondatos.configuracion.ConfiguracionEmpresas;
import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.ventanas.VentanaDatos;
import epsum.curso.conexiondatos.entidades.Hijo;
import lombok.Data;

@SpringBootApplication
@Data
@Import(ConfiguracionEmpresas.class)
public class ConexionDatosApplication implements CommandLineRunner {
	
	@Autowired
	private VentanaDatos ventanaDatos;
	
	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		//SpringApplication.run(ConexionDatosApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ConexionDatosApplication.class);

		builder.headless(false);
		builder.run(args);

		//ConfigurableApplicationContext context = builder.run(args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		getVentanaDatos().setVisible(true);
		
	}
	
	
	
	

} 