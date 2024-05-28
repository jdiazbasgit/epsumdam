package epsum.curso.conexiondatos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import epsum.curso.conexiondatos.entidades.Empleado;
import epsum.curso.conexiondatos.entidades.Empleado;

//@Repository
public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {

	//@Query(value="SELECT id,descripcion FROM empresas.cargos where descripcion like 'M%'",nativeQuery = true)
	//@Query("from Cargo as cargo where cargo.descripcion like :dato")
	//public List<Cargo> getCargosQueEmpiezanPor(String dato);
	
	public List<Empleado> findByDatoPersonalByHijoByChicasGreaterThan(int chicas);
}
