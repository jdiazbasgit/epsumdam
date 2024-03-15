package epsum.curso.conexiondatos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.repositorios.CargoCrudRepository;
import lombok.Data;

@SpringBootApplication
@Data
@EnableJpaRepositories("epsum.curso.conexiondatos.repositorios")
@ComponentScan(basePackages = { "epsum.curso.conexiondatos" })
@EntityScan("epsum.curso.conexiondatos.entidades") 
public class ConexionDatosApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConexionDatosApplication.class, args);
	}

}
