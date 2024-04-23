package epsum.curso.conexiondatos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epsum.curso.conexiondatos.entidades.Hijo;
import epsum.curso.conexiondatos.repositorios.HijoCrudRepository;
import lombok.Data;

@Service
@Data
public class HijoService {
	
	@Autowired
	private HijoCrudRepository hijoCrudRepository;
	
	public Iterable<Hijo> findAll(){
		return getHijoCrudRepository().findAll();
	}
	
	public Hijo save(Hijo hijo) {
		return getHijoCrudRepository().save(hijo);
	}
	

}