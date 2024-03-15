package epsum.curso.conexiondatos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.repositorios.CargoCrudRepository;
import lombok.Data;

@Service
@Data
public class CargoService {
	
	@Autowired
	private CargoCrudRepository cargoCrudRepository;
	
	public Iterable<Cargo> findAll(){
		return getCargoCrudRepository().findAll();
	}
	
	public Cargo save(Cargo cargo) {
		return getCargoCrudRepository().save(cargo);
	}

}
