package epsum.curso.conexiondatos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.EstadoCivil;
import epsum.curso.conexiondatos.repositorios.CargoCrudRepository;
import epsum.curso.conexiondatos.repositorios.EstadoCivilCrudRepository;
import lombok.Data;

@Service
@Data
public class EstadoCivilService {
	
	@Autowired
	private EstadoCivilCrudRepository estadoCivilCrudRepository;
	
	public Iterable<EstadoCivil> findAll(){
		return getEstadoCivilCrudRepository().findAll();
	}
	
	public EstadoCivil save(EstadoCivil estadoCivil) {
		return getEstadoCivilCrudRepository().save(estadoCivil);
	}
	
	/*public void delete(EstadoCivil estadoCivil) {
		 getEstadoCivilCrudRepository().delete(estadoCivil);
		 
	}
	
	public long count() {
		return getEstadoCivilCrudRepository().count();
	}
	
	*/

}
