package epsum.curso.conexiondatos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.DatoPersonal;
import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.repositorios.CargoCrudRepository;
import epsum.curso.conexiondatos.repositorios.DatosPersonalesCrudRepository;
import epsum.curso.conexiondatos.repositorios.EstadoCivilCrudRepository;
import lombok.Data;

@Service
@Data
public class DatosPersonalesService {
	
	@Autowired
	private DatosPersonalesCrudRepository datosPersonalesCrudRepository;
	
	public Iterable<DatoPersonal> findAll(){
		return getDatosPersonalesCrudRepository().findAll();
	}
	
	public DatoPersonal save(DatoPersonal datoPersonal) {
		return getDatosPersonalesCrudRepository().save(datoPersonal);
	}
	
	/*public void delete(EstadoCivil estadoCivil) {
		 getEstadoCivilCrudRepository().delete(estadoCivil);
		 
	}
	
	public long count() {
		return getEstadoCivilCrudRepository().count();
	}
	
	*/

}
