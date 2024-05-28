package epsum.curso.conexiondatos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epsum.curso.conexiondatos.entidades.Empleado;
import epsum.curso.conexiondatos.repositorios.EmpleadoCrudRepository;
import lombok.Data;

@Service
@Data
public class EmpleadoService {
	
	@Autowired
	private EmpleadoCrudRepository EmpleadoCrudRepository;
	
	public Iterable<Empleado> findAll(){
		return getEmpleadoCrudRepository().findAll();
	}
	
	public Empleado save(Empleado empleado) {
		return getEmpleadoCrudRepository().save(empleado);
	}
	
	public void deleteById(int id) {
	 getEmpleadoCrudRepository().deleteById(id);
	}
	
	public long count() {
	return getEmpleadoCrudRepository().count();
	}
	
	public List<Empleado> findByNombreEquals(String nombre){
		return getEmpleadoCrudRepository().findByNombreEquals(nombre);
	}
}
