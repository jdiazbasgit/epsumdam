package epsum.curso.conexiondatos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epsum.curso.conexiondatos.entidades.DatoLaboral;
import epsum.curso.conexiondatos.repositorios.DatoLaboralCrudRepository;
import lombok.Data;

@Service
@Data
public class DatoLaboralService {
	
	@Autowired
	private DatoLaboralCrudRepository datoLaboralCrudRepository;
	
	public Iterable<DatoLaboral> findAll(){
		return getDatoLaboralCrudRepository().findAll();
	}
	
	public DatoLaboral save(DatoLaboral datoLaboral) {
		return getDatoLaboralCrudRepository().save(datoLaboral);
	}
	
}
